package br.com.andersillva.gameflixcatalogoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GameflixCatalogoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameflixCatalogoApiApplication.class, args);
	}

}
