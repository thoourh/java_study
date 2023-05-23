package dev.sw.controllerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("/sample-payload")
    public SamplePayload samplePayloadGet(){
        return new SamplePayload("sw",10,"Developer");
    }

    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT) //
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload){
        logger.info(samplePayload.toString());
    }

    @PostMapping(
            value = "/sample-multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation,
            @RequestParam(value = "file", required = false)MultipartFile multipartFile
    ){

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
