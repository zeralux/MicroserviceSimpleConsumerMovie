package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.pojo.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		// 雖然可以透過@Value避險hard code問題 , 但事實上當堤共服務者將端點改變後,呼叫服務者仍然必須修改URL
		
//		User user = this.restTemplate.getForObject("http://localhost:8000/"+id ,User.class);
		User user = this.restTemplate.getForObject(this.userServiceUrl+id ,User.class);
		return user;
	}
}
