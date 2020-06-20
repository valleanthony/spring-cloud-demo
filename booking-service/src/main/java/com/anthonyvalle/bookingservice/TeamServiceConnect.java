package com.anthonyvalle.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@Service
public class TeamServiceConnect {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	private static String serviceUrl;
//	@Value("${user.api.uri}")
//	private final String apiUri = "/api/v1/";
//
//	public String getUrl() {
//		InstanceInfo instance = eurekaClient.getNextServerFromEureka("User-Service", false);
//		serviceUrl = instance.getHomePageUrl();
//		System.out.println(serviceUrl);
//		return serviceUrl.concat(apiUri);
//	}
//
//	public String getHelloWorld() {
//		String uri = getUrl() + "hello";
//		ResponseEntity<String> temp = restTemplate.getForEntity(uri, String.class);
//		return temp.getBody();
//	}

}
