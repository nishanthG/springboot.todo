package com.ng.basic_auth;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4500")
public class BasicAuthController {
    
    @GetMapping(path = "/basic_auth")
    public AuthenticationBean BasicAuth(){
        return new AuthenticationBean("Hello from Bean!");
    }
}