package dev.aquashdw.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//@Controller 뷰를 제공하거나 데이터를 제공하는 것으로 넓은 범위에서
//사용하는 어노테이션으로 리스폰스바디 어노테이션을 써야지
// 원하는 형태로 데이터를 보낼수 있다
//@RestController 는 리스폰스바디 필요없이 자동으로 붙은것과 동일한 효과가 난다
// +@RequestMapping 클래스에도  붙여줄수 있다.
@RestController
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);
    @GetMapping("/sample-payload")
    public SamplePayload samplePayload(){
        return new SamplePayload("aquashdw",10,"Developer");

    }

    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE

    )
    public byte[] sampleImage() throws IOException {
        // 이미지든 영상이든 바이트를 돌려준다
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");
       // inputStream = new FileInputStream(new File(""));
        // 파일 인풋스트림을 사용해서 인풋스트림을 받아올수있다
        return inputStream.readAllBytes();
    }
}
