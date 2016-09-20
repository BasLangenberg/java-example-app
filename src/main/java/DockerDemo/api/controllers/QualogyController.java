package docker.demo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QualogyController extends ApiController {

    @RequestMapping(value="/q-demo", method= RequestMethod.GET)
    public String hello() { return "<h1>Qualogy Demo</h1>"; }

}