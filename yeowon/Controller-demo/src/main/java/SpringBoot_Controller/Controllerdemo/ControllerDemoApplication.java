package SpringBoot_Controller.Controllerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication 인해 스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정된다.
// @SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에
//  이 클래스는 항상 프로젝트 최상단에 위치해야 한다.
@SpringBootApplication
public class ControllerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerDemoApplication.class, args);
	}

}
// 내장 WAS 덕분에 톰캣을 설치할 필요가 없어지며, 스프링부트로 만들어진 Jar 파일로 실행하면 된다.
// 내장 WAS를 꼭 써야 하는 건 아니지만 권장하고 있다.