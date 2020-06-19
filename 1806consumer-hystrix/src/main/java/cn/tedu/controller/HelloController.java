package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.client.EurekaServiceFeign;

@RestController
public class HelloController  {

	@Autowired
	private EurekaServiceFeign eurekaServiceFeign;
	@GetMapping("/hello/{name}")
	@ResponseBody
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello(@PathVariable("name") String name) {
		
		return eurekaServiceFeign.hello(name);
		
		
	}
	
	public String helloFallback(String name) {
		
		
		return "error huanchun";
		
	}
	
}
