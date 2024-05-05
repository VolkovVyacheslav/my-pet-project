package com.vokov.manager.config;

import com.vokov.manager.client.RestClientProductsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientProductsRestClient productsRestClient(
            @Value("${market.services.catalogue.uri:http://localhost:8081}") String catalogueBaseUri,
            @Value("${market.services.catalogue.username:}") String catalogueUsername,
            @Value("${market.services.catalogue.password:}") String cataloguePassword){
        return new RestClientProductsRestClient(RestClient.builder()
                .baseUrl(catalogueBaseUri)
                .requestInterceptor(new BasicAuthenticationInterceptor(catalogueUsername, cataloguePassword))
                .build());
    }
}
