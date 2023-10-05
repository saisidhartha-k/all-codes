package com.talentsprint.cycleshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class EndpointDiscoveryService {

    private final DiscoveryClient discoveryClient;

    public EndpointDiscoveryService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public List<String> discoverEndpoints(String serviceName) {
        List<String> endpoints = new ArrayList<>();
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

        for (ServiceInstance instance : instances) {
            endpoints.add(instance.getUri().toString());
        }

        return endpoints;
    }
}
