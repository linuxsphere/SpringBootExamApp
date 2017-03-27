package com.xinglie.exam;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class App  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new App()
				.configure(new SpringApplicationBuilder(App.class))
				.run(args);
	}

}