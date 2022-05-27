package HCHH.Spring.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apitestController {
    @GetMapping("/api/hello")
    public String sayhello(){

        return "Hello world히히!!!!!!!!!1";
    }

}
