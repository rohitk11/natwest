# natwest

This application was generated using JHipster 7.7.0, you can find documentation and help at [https://www.jhipster.tech](https://www.jhipster.tech).

This is a "microservice" application intended to be part of a microservice architecture, please refer to the [Doing microservices with JHipster][] page of the documentation for more information.
This application is configured for Service Discovery and Configuration with the JHipster-Registry. On launch, it will refuse to start if it is not able to connect to the JHipster-Registry at [http://localhost:8761](http://localhost:8761). For more information, read our documentation on [Service Discovery and Configuration with the JHipster-Registry][].

. **Pre-requisite -- Jhipster-Registry**

- install npm
- install jhipster by running this command : npm install -g generator-jhipster

- download registry


    1. Download link -- https://github.com/jhipster/jhipster-registry/releases/download/v5.0.2/jhipster-registry-5.0.2.jar
    * put it folder and run following command to start the registry (Always start the registry first)
    2. Command -- java -jar jhipster-registry-5.0.2.jar --spring.security.user.password=admin --jhipster.security.authentication.jwt.secret=my-secret-key-which-should-be-changed-in-production-and-be-base64-encoded --spring.cloud.config.server.composite.0.type=native --spring.cloud.config.server.composite.0.search-locations=file:./central-config

## Project Structure

- mysql - created one user
  1.CREATE USER 'natwest'@'localhost' IDENTIFIED BY 'natwest';
  2.GRANT ALL PRIVILEGES ON _._ TO 'natwest'@'localhost';

\*natwest microService will start on port 8080
. **To start natwest --**
./mvnw -P-webpack
saaaggaaar
jukijkuihnui
iokjljj