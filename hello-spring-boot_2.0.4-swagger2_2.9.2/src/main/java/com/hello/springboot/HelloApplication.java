package com.hello.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication注解呢是SpringBoot的一个组合注解，
 * 主要注解为@Configuration、@EnableAutoConfiguration、@ComponentScan
 */
@SpringBootApplication
public class HelloApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
}
