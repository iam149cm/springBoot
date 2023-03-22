package co.iam149cm.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* @ResponseBody annotation tells a controller that  the object returned is
*  automatically serialized into JSON and passed back into the HttpResponse object */

// @RestController = @Controller + @ResponseBody
public class HelloWorldController {

    // HTTP GET Request - Http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world!";
    }
}
