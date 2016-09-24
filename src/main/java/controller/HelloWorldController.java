package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author renzobelve
 *
 * RestController HelloWorld
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello World Futbolero!";
    }

}
