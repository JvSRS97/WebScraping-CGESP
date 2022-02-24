package jvreis.webscrapingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebscrapingTestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WebscrapingTestApplication.class, args);
		new ScrapingConfiguration();
	}

}
