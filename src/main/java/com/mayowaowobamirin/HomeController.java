package com.mayowaowobamirin;


import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public SimpleResponse index() {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setMessage("Hello World");
        simpleResponse.setStatus("success");
        return simpleResponse;
    }

    @GetMapping("/messages")
    public SimpleResponse echoMessageViaGet(@RequestParam(name = "message") String message) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus("success");
        simpleResponse.setMessage(message);
        return simpleResponse;
    }

    @PostMapping("/messages")
    public SimpleResponse echoMessageViaPost(@RequestBody SimpleResponse request) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(request.getStatus());
        simpleResponse.setMessage(request.getMessage());
        return simpleResponse;
    }
}
