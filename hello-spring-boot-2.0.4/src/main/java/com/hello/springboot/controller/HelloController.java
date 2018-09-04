package com.hello.springboot.controller;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @RestController注解相当于 @ResponseBody ＋ @Controller合在一起的作用。
 * 如果只是使用@Controller注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 *
 * 用@Controller，返回的是页面；@Controller加上@ResponseBody，返回的是JSON、XML或其他文本。
 */
@RestController
@RequestMapping(value="/hello")
public class HelloController {

	@RequestMapping(value="/demo/get", method=RequestMethod.GET)
	@ResponseBody
	public String demoGet() {
		return "Hello get";
	}

	@GetMapping(value="/demo/get2")
	public String demoGet2() {
		return "Hello get2";
	}

	@RequestMapping(value="/demo/post", method=RequestMethod.POST)
	@ResponseBody
	public String demoPost() {
		return "Hello post";
	}

	@PostMapping(value="/demo/post2")
	public String demoPost2() {
		return "Hello post2";
	}

}
