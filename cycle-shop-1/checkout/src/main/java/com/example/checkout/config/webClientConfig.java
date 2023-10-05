package com.example.checkout.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.checkout.client.cycleClient;


@Configuration
public class webClientConfig {
    
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient employWebClient()
    {
        return WebClient.builder()
        .baseUrl("http://CYCLE-SERVICE")
        .filter(filterFunction)
        .build();
    }

    @Bean
    public cycleClient employeeClient()
    {
        HttpServiceProxyFactory httpServiceProxyFactory 
        = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(employWebClient()))
        .build();

        return httpServiceProxyFactory.createClient(cycleClient.class);
    }
}
