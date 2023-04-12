package io.iam149cm.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // this annotation will make the spring cloud config server to refresh the configuration files
@RestController
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
