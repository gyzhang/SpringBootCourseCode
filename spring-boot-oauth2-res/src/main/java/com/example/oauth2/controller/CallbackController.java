package com.example.oauth2.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class CallbackController {
	/**
	 * 用code到授权服务器获取access_token，然后访问index主页
	 * 
	 * @param code
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public ResponseEntity<String> callback(@RequestParam("code") String code) throws JsonProcessingException, IOException {
		ResponseEntity<String> response = null;
		System.out.println("Authorization Code: " + code);
		RestTemplate restTemplate = new RestTemplate();
		String access_token_url = "http://localhost:8000/oauth/token";
		access_token_url += "?client_id=client_123456&code=" + code;
		access_token_url += "&client_secret=secret_123456";
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=http://localhost:8080/callback";
		System.out.println("access_token_url: " + access_token_url);
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, null, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();
		System.out.println("access_token: " + token);
		String url = "http://localhost:8080/index";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return result;
	}

}
