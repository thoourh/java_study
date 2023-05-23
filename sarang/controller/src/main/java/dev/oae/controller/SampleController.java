package dev.oae.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class SampleController {
    private  static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);
    @GetMapping("/sample-jsp")
    public String sampleJsp() {
        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePa)
        return "view-jsp";
    }

}
