package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webclient.MyWebClient;

@RestController
public class SimpleRestApi {
	
	@Autowired
	MyWebClient webClient;

	@GetMapping("/")
	public void llamada() {
		System.out.println("llamando service..");
		webClient.doPost();
	}
}
