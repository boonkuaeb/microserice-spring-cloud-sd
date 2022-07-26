package com.bk.microservice.core.product.configuration;

import com.bk.microservices.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConf {

    @Value("${server.port}")
    String servicePort;

    @Bean
    public ServiceUtil serviceUtil()
    {
        return new ServiceUtil(servicePort);
    }
}
