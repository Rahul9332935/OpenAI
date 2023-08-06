package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest.Headers;


@RestController
public class ChatGTP {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/get")
	public ResponseEntity<String> getData(@RequestBody String prompt){
		String api = "https://api.openai.com/v1/chat/completions";
		String apikey = "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";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(apikey);
//		
		RequestPayload payload = new RequestPayload(prompt);
		HttpEntity<RequestPayload> httpEntity = new HttpEntity<>(payload ,headers);
//		
		ResponseEntity<String> data= restTemplate.postForEntity(api,httpEntity ,String.class);
//		
//		if(data.getStatusCode().is2xxSuccessful()) {
//			return data;
//		}
//		return new ResponseEntity<String>("try again!!", data.getStatusCode());
		return new ResponseEntity<String>(.toString(), HttpStatus.OK);
	}
}

