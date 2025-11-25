package samuelfac.organizze.client.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import samuelfac.organizze.client.OrganizzeClient;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.util.TimeZone;

@Configuration
public class HttpExchangeConfig {

    @Value("${organizze.user}")
    String user;

    @Value("${organizze.pass}")
    String pass;

    @Value("${organizze.agent}")
    String agent;

    /**
     * Configures the RestClient with Jackson 3, Basic Auth, and Headers.
     * Replaces Feign's Decoder, Encoder, and Interceptors.
     */
    @Bean
    public RestClient organizzeRestClient(ObjectMapper jackson3ObjectMapper) {
        return RestClient.builder()
                .defaultHeader(HttpHeaders.USER_AGENT, agent)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                // Replaces BasicAuthRequestInterceptor
                .requestInitializer(request -> request.getHeaders().setBasicAuth(user, pass))
                .build();
    }

    /**
     * Creates the Proxy Factory.
     * This allows you to inject your interface (e.g., @Autowired OrganizzeClient) elsewhere.
     */
    @Bean
    public HttpServiceProxyFactory organizzeProxyFactory(RestClient organizzeRestClient) {
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(organizzeRestClient))
                .build();
    }

    /**
     * Jackson 3.0.2 Configuration.
     * Note the package change to 'tools.jackson' for the Mapper and Features.
     */
    @Bean
    public ObjectMapper jackson3ObjectMapper() {
        return JsonMapper.builder()
                .defaultTimeZone(TimeZone.getDefault())
                .changeDefaultPropertyInclusion(incl -> incl.withValueInclusion(JsonInclude.Include.NON_NULL))
                .build();
    }

    @Bean
    public OrganizzeClient organizzeClient(HttpServiceProxyFactory factory) {
        return factory.createClient(OrganizzeClient.class);
    }
}