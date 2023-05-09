package dev.oae.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller //34
@RequestMapping("view")
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

//    @GetMapping(value = "/hello")
   // public String hello (@RequestParam(name = "id", required = false, defaultValue = "")String id){
    //    logger.info("Path: Hello");
      //  logger.info("Query Param id: "+ id);
        //return "/hello.html";
    //}
    //기초적으로 요청을 받는
 //   @GetMapping(value = "/hello/{id}")
 //   public String helloPath(@PathVariable("id")String id) {
 //       logger.info("Path Variable is : "+id);
 //       return "/hello.html";
 //   }

 //   @GetMapping("/get-profile" //경로설정)
    //public @ResponseBody SamplePayload getProfile() {
   //     return new SamplePayload("sr", 10,"Developer");
   // } //3-2 31
    @GetMapping("/sample-jsp") //여기 경로로 요청이들어오면
    public String sampleJsp(Model model) {
        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam",22,"Student"));
        profiles.add(new SamplePayload("Brand",29,"Accountant"));
        profiles.add(new SamplePayload("Sarang",23,"Developer"));
        model.addAttribute("profiles",profiles);

        return "view-jsp";
    }

    @GetMapping("/sample-thyme")
    public ModelAndView sampleThyme(){
        logger.info("in sample thyme");
        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam",22,"Student"));
        profiles.add(new SamplePayload("Brand",29,"Accountant"));
        profiles.add(new SamplePayload("Sarang",23,"Developer"));

        modelAndView.addObject("profiles", profiles);
        modelAndView.setViewName("view-thyme");
        return modelAndView;
    }

}
