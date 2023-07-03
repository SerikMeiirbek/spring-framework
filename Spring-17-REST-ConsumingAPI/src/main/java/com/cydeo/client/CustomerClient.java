package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(url = "http://localhost:8080/api/v1", name = "CUSTOMER-CLIENT")
public interface CustomerClient {

    @GetMapping("/customers")
    ResponseEntity<List<Object>> getCustomer();

}
