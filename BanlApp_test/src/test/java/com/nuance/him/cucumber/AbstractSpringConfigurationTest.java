
package com.nuance.him.cucumber;

import javax.sql.DataSource;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static junit.framework.TestCase.fail;

@ContextConfiguration(classes = AbstractSpringConfigurationTest.Config.class)
@DirtiesContext
public abstract class AbstractSpringConfigurationTest {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractSpringConfigurationTest.class);

    @Autowired(required=false)
    private TestRestTemplate restTemplate;
    @Autowired
    @Qualifier("prodJdbcTemplate")
    private NamedParameterJdbcTemplate prodJdbcTemplate;
    private static Response response;
    private static final Map<String, String> HEADERS = new HashMap<>();

    protected ObjectMapper mapper = new ObjectMapper();
    protected static final String HOST="http://localhost:";
    static final String BASE_URL = "/bank";

    private static final int RETRY = 20;
    private static final String APP_NAME = "BankMainApp";

    static {
        HEADERS.put(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE);
        HEADERS.put(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_UTF8_VALUE);
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        String url = getAppUrl();
        for (int i = 1; i <= RETRY; i++) {
            LOG.info("Connecting: {}, attempt: {}", url, i);
            try {
                if (APP_NAME.equals(getResponse("/info").path("app.name"))) {
                    LOG.info("Connected: {}, attempt: {}", url, i);
                    return;
                }
            }
            catch (Exception e) {
                Thread.sleep(1000);
                LOG.warn("{} endpoint not accessible. Sleeping ({} of {}) ...", url, i, RETRY, e);
            }
        }
        fail("The application is not running");
    }


    private static String getAppUrl() throws IOException {
        try (FileInputStream is = new FileInputStream("./src/test/resources/serverPort.properties")) {
            Properties props = new Properties();
            props.load(is);
            return HOST + props.getProperty("serverPort");
        }
    }

    static String getResponseAsString(final String path) throws Exception {
        return validateResponse(getResponse(path)).asString();
    }

    static Response getResponse(final String path) throws Exception {
        return getResponse(path, Collections.emptyMap(), Collections.emptyMap());
    }

    static Response getResponse(final String path, final Map<String, Object> requestParams, final Map<String, Object> pathParams) throws Exception {
        return setResponse(getRequestSpecification(requestParams).get(path, pathParams));
    }

    static Response putResponse(final String path, final Map<String, Object> pathParams) throws Exception {
        return setResponse(getRequestSpecification(Collections.emptyMap()).put(path, pathParams));
    }

    static Response deleteResponse(final String path, final Map<String, Object> requestParams, final Map<String, Object> pathParams) throws Exception {
        return setResponse(getRequestSpecification(requestParams).delete(path, pathParams));
    }

    private static Response setResponse(final Response resp) {
        response = resp;
        assertNotNull(response);
        assertNotNull(response.body());
        response.getBody().print();
        return response;
    }

    private static RequestSpecification getRequestSpecification(final Map<String, Object> requestParams) throws Exception {
        return RestAssured.given().baseUri(getAppUrl()).headers(HEADERS).queryParams(requestParams).when();
    }

    static Response validateResponse() {
        return validateResponse(HttpStatus.OK);
    }

    static Response validateResponse(final HttpStatus status) {
        return validateResponse(response, status);
    }

    private static Response validateResponse(final Response response) {
        return validateResponse(response, HttpStatus.OK);
    }

    private static Response validateResponse(final Response response, final HttpStatus status) {
        assertEquals(status.value(), response.statusCode());
        return response;
    }



    public TestRestTemplate getRestTemplate() {

        return restTemplate !=null ? restTemplate : new TestRestTemplate();
    }

    public void setRestTemplate(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> invokeRESTCall(String url,HttpMethod method,HttpEntity<?> requestEntity){

        return getRestTemplate().exchange(url,method,requestEntity, String.class);
    }


    public HttpHeaders getDefaultHttpHeaders(){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept((List<MediaType>) MediaType.APPLICATION_JSON);
        return headers;
    }



    public String buildUrl(String host,String port,String path,Map<String,String> uriVariables){
        UriComponentsBuilder builder=UriComponentsBuilder.fromPath(path)
            .host(host)
            .port(port)
            .scheme("http");
        UriComponents uriComponent= uriVariables !=null && !uriVariables.isEmpty() ?  builder.buildAndExpand(uriVariables) : builder.build();
        return uriComponent.toUri().toString();
    }

    public String buildUrl(String host,String port,String path){
        return buildUrl(host, port, path,null);
    }


    @Configuration
    @PropertySource("classpath:test.properties")
    static class Config {
        @Value("${jdbc.driver}")
        private String driverClass;
        @Value("${jdbc.url.prod}")
        private String prodJdbcUrl;
          @Value("${jdbc.user}")
        private String jdbcUser;
        @Value("${jdbc.password}")
        private String jdbcPassword;

        @Bean
        NamedParameterJdbcTemplate prodJdbcTemplate() throws Exception {
            return new NamedParameterJdbcTemplate(prodDataSource());
        }

        @Bean
        DataSource prodDataSource() throws Exception {
            return dataSource(prodJdbcUrl);
        }

        private DataSource dataSource(final String url) throws Exception {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(jdbcUser);
            dataSource.setPassword(jdbcPassword);
            return dataSource;
        }

        @Bean
        static PropertySourcesPlaceholderConfigurer propertySources() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }


}
