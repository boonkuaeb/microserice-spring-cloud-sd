package com.bk.secureapi.config;

import com.bk.secureapi.model.Forbidden;
import com.bk.secureapi.repository.ForbiddenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class CacheInit {

    @Autowired
    private ForbiddenRepo forbiddenRepo;

    @PostConstruct
    private void postConstruct() {
        Forbidden endpoint = new Forbidden();
        String key = "product_99-ADMIN-NORMALUSER".toLowerCase();
        endpoint.setId(key);
        endpoint.setDescription("Whe route product and productId 99 and staff role ADMIN and customer role NORMAL_USER");
        forbiddenRepo.save(endpoint);
        System.out.println("Add redis test data,"+key);

        Forbidden endpoint2 = forbiddenRepo.findById(key);
        System.out.println(endpoint2.getDescription());
    }
}