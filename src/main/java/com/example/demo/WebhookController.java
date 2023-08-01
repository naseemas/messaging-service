package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@RestController
public class WebhookController {

    @GetMapping(value = "/webhooks")
    public ResponseEntity<Object> getTestData(@RequestParam("hub.verify_token") String token) {
    	if(token.equals("HariMagicMessage")) {
       return ResponseEntity.ok().build();
    	}
    	 return ResponseEntity.notFound().build();
    }
    
    @PostMapping(value = "/webhooks")
    public ResponseEntity<Object> readUserResponse(@RequestBody Object dto) {
    	  return ResponseEntity.ok(dto);
    }
    @GetMapping(value = "/")
    public ResponseEntity<String> ping(){
       return ResponseEntity.ok("I am listening Bro..");
    }
}