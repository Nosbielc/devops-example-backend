package nosbielc.com.devops.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
@RestController
@RequestMapping(value ="/")
public class RootController {
    @GetMapping
    public String hello() {
        return "I'm alive!";
    }
}

