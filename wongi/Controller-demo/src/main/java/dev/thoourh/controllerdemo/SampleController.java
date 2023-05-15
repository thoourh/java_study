package dev.thoourh.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);


    @GetMapping(
            value = "hello"
    )
    public String hello(@RequestParam(name = "id", required = false, defaultValue = "") String id){
        logger.info("Query Parma id: " + id);
        logger.info("Path: Hello");
        return "hello.html";
    }

    @GetMapping(
            value = "hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is:" + id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getprofile(){
        return new SamplePayload("thoourh", 10, "stuent");
    }
}
