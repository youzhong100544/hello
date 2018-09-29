package com.hello.spring.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 通过@Configuration注解，表明它是一个配置类，@EnableSwagger2开启swagger2。
 *
 * apiINfo()配置一些基本的信息。
 * apis()指定扫描的包会生成文档。
 * 再通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
 *
 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//为当前包路径
				.apis(RequestHandlerSelectors.basePackage("om.hello.springboot.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	//构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("Spring Boot 测试使用 Swagger2 构建RESTful API")
				//创建人
				.contact(new Contact("hello", "http://www.baidu.com", "email@email.com"))
				//版本号
				.version("1.0")
				//描述
				.description("用户管理")
				.build();
	}

}
