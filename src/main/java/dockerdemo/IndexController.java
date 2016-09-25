package dockerdemo;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "<h1>Hi Qualogy!</h1><p>Im abusing Springs error page, please dont judge me...";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}