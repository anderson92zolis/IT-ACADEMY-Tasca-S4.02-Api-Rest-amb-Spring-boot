package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain")
public class S04T02N02ZolisChipantasigAndersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N02ZolisChipantasigAndersonApplication.class, args);
	}
}
