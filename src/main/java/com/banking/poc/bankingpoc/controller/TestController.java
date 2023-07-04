package com.banking.poc.bankingpoc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping("/hello")
    public ResponseEntity<String> printHello(){

        return ResponseEntity.ok("Hello World");

    }

    @PostMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestBody String name){

        String message = "Hello, " + name + ".";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

}
