package org.ucb.service.model;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Tservice {

	public Greeting doInd() {
		Greeting greeting = null;
		final String url = "http://rest-service.guides.spring.io/greeting";	
    	RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        greeting = restTemplate.getForObject(url, Greeting.class);
        return greeting;
    }
	
}
