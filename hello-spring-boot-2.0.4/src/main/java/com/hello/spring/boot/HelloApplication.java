package com.hello.spring.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @SpringBootApplication注解呢是SpringBoot的一个组合注解，
 * 主要注解为@Configuration、@EnableAutoConfiguration、@ComponentScan
 *
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 *
 * @Configuration,@ComponentSca这俩注解语法是spring框架中的。起步于spring 3.x
 * @EnableAutoConfiguration是spring boot语法，表示自动配置。
 */
@SpringBootApplication
public class HelloApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	/**
	 * springboot在启动的时候为我们注入了哪些bean
	 *
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
		return args -> {
			long startTime = 0l;
			long endTime = 0l;
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
			System.out.println("beanDefinitionCount:" + beanDefinitionCount);
			String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
			Arrays.sort(beanDefinitionNames);
			System.out.println("beanDefinitionName:");

			startTime = System.currentTimeMillis();
			for (int i = 0; i < beanDefinitionNames.length; i++) {
				System.out.println(beanDefinitionNames[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.println("execution time:" + (endTime - startTime));
		};
	}
}
