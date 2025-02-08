package com.kasprzak.kamil.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kasprzak.kamil.demoapp")
public class DemoAappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAappApplication.class, args);
	}

}
