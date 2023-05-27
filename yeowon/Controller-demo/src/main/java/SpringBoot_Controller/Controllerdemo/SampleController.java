package SpringBoot_Controller.Controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("view")
public class SampleController{
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-jsp")
    public String sampleJsp(Model model) {

        // ModelAndView modelAndView = new ModelAndView();
        // modelAndView.setViewName();

        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("Bradley", 29, "Accountant"));
        profiles.add(new SamplePayload("Charlie", 35, "Developer"));

        model.addAttribute("profiles", profiles);

        return "view-jsp";
        }

        @GetMapping("/sample-thyme")
            public ModelAndView sampleThyme(){
            logger.info("in sample thyme");
            ModelAndView modelAndView = new ModelAndView();
            List<SamplePayload> profiles = new ArrayList<>();
            profiles.add(new SamplePayload("Adam", 22, "Student"));
            profiles.add(new SamplePayload("Bradley", 29, "Accountant"));
            profiles.add(new SamplePayload("Charlie", 35, "Developer"));

            modelAndView.addObject("profiles", profiles);
            modelAndView.setViewName("view-thyme");

            return modelAndView;
    }


    /* @GetMapping(
            value = "/hello"
    )
    public String hello(
            @RequestParam(name = "id", required = false, defaultValue = "") String id){
        logger.info("Path: Hello");
        logger.info("Query Param id: " + id);
        return "/hello.html";
    }

    @GetMapping(
            value = "/hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id) {
        logger.info("Path Variable is: " + id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile() {
        return new SamplePayload ("yeowon", 10, "Developer");
    }*/
}
