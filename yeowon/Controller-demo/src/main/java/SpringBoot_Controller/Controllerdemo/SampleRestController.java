package SpringBoot_Controller.Controllerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import javax.swing.plaf.PanelUI;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-payloadGet")
    public SamplePayload samplePayload(){
        return new SamplePayload ("yeowon", 10, "Developer");
    }

    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload){
        logger.info(samplePayload.toString());
    }

    @PostMapping(
            value = "/sample-multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void sampleMultipartPost(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation
            // @RequestParam("file origin name" + MultipartFile multipartFile
    ){
        logger.info("name: " + name);
        logger.info("age: " + age);
        logger.info("occupation: " + occupation );
        // logger.info("file original name: " + multipartFile.getOriginalFilename());
    }


    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] sampleImage() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");

        return inputStream.readAllBytes();
    }
}
