package com.hello.spring.boot.configuration;

import com.hello.spring.boot.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @Configuration
 *
 * 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
 *
 * 注意：@Configuration注解的配置类有如下要求：
 *
 *     @Configuration不可以是final类型；
 *
 *     @Configuration不可以是匿名类；
 *
 *     嵌套的configuration必须是静态类。
 *
 * @Configuration配置spring并启动spring容器
 *
 * @Configuration标注在类上，相当于把该类作为spring的xml配置文件中的，作用为：配置spring容器(应用上下文)
 *
 *
 *
 * 相当于
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 * <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *     xmlns:context="http://www.springframework.org/schema/context" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
 *     xmlns:jee="http://www.springframework.org/schema/jee" xmlns:tx="http://www.springframework.org/schema/tx"
 *     xmlns:util="http://www.springframework.org/schema/util" xmlns:task="http://www.springframework.org/schema/task" xsi:schemaLocation="
 *         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
 *         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
 *         http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-4.0.xsd
 *         http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-4.0.xsd
 *         http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd
 *         http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.0.xsd
 *         http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.0.xsd" default-lazy-init="false">
 * </beans>
 *
 */
@Configuration
public class TestConfiguration {
	public TestConfiguration() {
		System.out.println("TestConfiguration容器启动初始化。。。");
	}

	/*
	@Bean
	@Bean标注在方法上(返回某个实例的方法)，等价于spring的xml配置文件中的，作用为：注册bean对象。

	@Bean注解注册bean,同时可以指定初始化和销毁方法
	@Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")

	注
	(1)、@Bean注解在返回实例的方法上，如果未通过@Bean指定bean的名称，则默认与标注的方法名相同；
	(2)、@Bean注解默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为原型作用域；
	(3)、既然@Bean的作用是注册bean对象，那么完全可以使用@Component、@Controller、@Service、@Ripository等注解注册bean，当然需要配置@ComponentScan注解进行自动扫描。

	 */

	@Scope("prototype")
	// @Bean注解注册bean,同时可以指定初始化和销毁方法
	@Bean(name = "testBean", initMethod = "start", destroyMethod = "cleanUp")
	public TestBean testBean() {
		return new TestBean();
	}


}
