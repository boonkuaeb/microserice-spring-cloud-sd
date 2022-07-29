package com.bk.secureapi.services;

import com.bk.secureapi.model.Forbidden;
import com.bk.secureapi.repository.ForbiddenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class ForbiddenService implements ForbiddenRepo {

    private final String FORBIDDEN_CACHE = "FORBIDDEN";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Forbidden> hashOperations;

    // This annotation makes sure that the method needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    // Save operation.
    @Override
    public void save(final Forbidden forbidden) {
        hashOperations.put(FORBIDDEN_CACHE, forbidden.getId(), forbidden);
    }

    // Find by employee id operation.
    @Override
    public Forbidden findById(final String id) {
        return (Forbidden) hashOperations.get(FORBIDDEN_CACHE, id);
    }

    // Find all employees' operation.
    @Override
    public Map<String, Forbidden> findAll() {
        return hashOperations.entries(FORBIDDEN_CACHE);
    }

    // Delete employee by id operation.
    @Override
    public void delete(String id) {
        hashOperations.delete(FORBIDDEN_CACHE, id);
    }


}