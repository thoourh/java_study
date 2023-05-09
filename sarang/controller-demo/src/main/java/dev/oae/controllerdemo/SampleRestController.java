package dev.oae.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController //35 데이터 주고 받음
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-payload")
    public SamplePayload samplePayload(){
        return new SamplePayload("sr", 10,"Developer");
    }

    @GetMapping(value = "/sample-image",
    produces = MediaType.IMAGE_PNG_VALUE) //이미지든 비디오든 어떠한 형태든 데이터 바이트
    public byte[] sampleImage() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");
        return inputStream.readAllBytes();
    }//이미지 byte
}
