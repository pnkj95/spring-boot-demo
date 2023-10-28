package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication implements ApplicationRunner{

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootDemoApplication.class, args);
		SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		app.setBannerMode(Mode.OFF);
	    app.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("System has started successfully and checking the implementation of Runner Interface########");
		
	}

}
