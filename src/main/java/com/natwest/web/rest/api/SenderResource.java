package com.natwest.web.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.service.dto.EncryptedTransactionDTO;
import com.natwest.service.dto.TransactionDTO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sender")
public class SenderResource {

    private final Logger log = LoggerFactory.getLogger(SenderResource.class);

    @PostMapping
    public ResponseEntity<TransactionDTO> processRequest(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        @RequestBody TransactionDTO dto
    ) throws Exception {
        log.info("REST request to sender : {}", dto);
        //Just adding a Encrypted DTO not such encryption
        EncryptedTransactionDTO encrDTO = encrypt(dto);
        //Calling receiver API
        TransactionDTO result = callReceiver(encrDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private static EncryptedTransactionDTO encrypt(TransactionDTO dto) {
        EncryptedTransactionDTO encrDTO = new EncryptedTransactionDTO();
        encrDTO.setBody(dto);
        return encrDTO;
    }

    public TransactionDTO callReceiver(EncryptedTransactionDTO dto) throws IOException, Exception {
        String requestJson = new JSONObject(dto).toString();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        String response = post("http://localhost:8081/receiver", headers, requestJson);
        log.info("response for receiver Api: {}", response);
        TransactionDTO onBoardApiResponseParameterDto = new ObjectMapper().readValue(response, TransactionDTO.class);
        return onBoardApiResponseParameterDto;
    }

    public String post(final String url, Map<String, String> headers, final String requestBodyJson)
        throws ClientProtocolException, IOException {
        int timeout = 30;
        log.info("posting request for url :{} with headers :{},with requestBody: {}", url, headers, requestBodyJson);
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(requestBodyJson);
        httpPost.setEntity(entity);
        for (String key : headers.keySet()) {
            httpPost.setHeader(key, headers.get(key));
        }
        RequestConfig config = RequestConfig
            .custom()
            .setConnectTimeout(timeout * 1000)
            .setConnectionRequestTimeout(timeout * 1000)
            .setSocketTimeout(timeout * 1000)
            .build();
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config).build();
        try {
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity responseEntity = response.getEntity();
                    return responseEntity != null ? EntityUtils.toString(responseEntity) : null;
                } else {
                    log.error("response status for request url :{} is :{}", url, status);
                    log.info("Entity {}", EntityUtils.toString(response.getEntity()));
                    throw new ClientProtocolException("Unexpected response status:{}" + status);
                }
            };
            String response = client.execute(httpPost, responseHandler);
            log.info("response for request url :{} is :{}", url, response);
            return response;
        } finally {
            client.close();
        }
    }
}
