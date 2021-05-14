package com.ng.webservice.restfulwebservices.helloworld;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4500")
public class HelloworldController {
    
    @GetMapping(path = "/hello-world")
    public String hello_world(){
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello from Bean!");
    }

    @GetMapping(path = "/hellosays/{name}")
    public HelloWorldBean SayHello(@PathVariable  String name){
        return new HelloWorldBean(String.format("Welcome home, %s!", name));
    }
}