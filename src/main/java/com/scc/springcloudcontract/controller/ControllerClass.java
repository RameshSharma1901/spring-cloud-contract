package com.scc.springcloudcontract.controller;

import com.scc.springcloudcontract.model.TypicodePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerClass {


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/endpoint1")
    public ResponseEntity getDetails() {
        ResponseEntity responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        try {
//            responseEntity = new ResponseEntity(restTemplate.getForObject("http://localhost:8092/api",
//                    TypicodePojo[].class), HttpStatus.OK);
            responseEntity=restTemplate.exchange(
                    "http://localhost:8092/api/endpoint1", HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            System.out.print("Error occurred while connecting external api");
            System.out.print(e.getMessage());
            responseEntity = new ResponseEntity("Error While connecting external api", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
