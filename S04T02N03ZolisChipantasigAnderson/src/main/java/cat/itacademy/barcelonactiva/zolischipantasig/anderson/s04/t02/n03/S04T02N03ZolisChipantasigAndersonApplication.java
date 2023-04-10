package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackages = "cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.repository")
public class S04T02N03ZolisChipantasigAndersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03ZolisChipantasigAndersonApplication.class, args);
	}
}
