package com.xinglie.exam;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.xinglie.exam.repository")
@ImportResource({"classpath*:appContext.xml"})
public class App  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new App()
				.configure(new SpringApplicationBuilder(App.class))
				.run(args);
	}

}