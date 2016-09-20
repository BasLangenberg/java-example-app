package dockerdemo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends ApiController {

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello() { return "Hello Backend Server"; }

}