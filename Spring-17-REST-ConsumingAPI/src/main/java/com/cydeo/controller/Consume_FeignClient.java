package com.cydeo.controller;

import com.cydeo.client.CustomerClient;
import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    private final CustomerClient customerClient;


    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved", userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("Success", employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }


    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<Object>> getCustomers(){
        return customerClient.getCustomer();
    }

    @GetMapping("/api/v1/dummy")
    public List<LinkedHashMap<String,String>> getDummyEndPoints(){

        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject("https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8", List.class);

    }


}
