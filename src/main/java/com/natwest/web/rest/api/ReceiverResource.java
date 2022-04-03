package com.natwest.web.rest.api;

import com.natwest.service.dto.TransactionDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receiver")
public class ReceiverResource {

    private final Logger log = LoggerFactory.getLogger(ReceiverResource.class);

    @PostMapping
    public ResponseEntity<TransactionDTO> processRequest(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        @RequestBody TransactionDTO dto
    ) throws Exception {
        log.info("hihihhihihi");
        log.info("REST request to receiver : {}", dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
