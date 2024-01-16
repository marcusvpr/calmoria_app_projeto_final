package com.mpxds.apps.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MpOpenAIConfig {
	//
    @Value("${openai.api.key}")
    String openaiApiKey;

    @Bean
    RestTemplate template() {
    	//
        RestTemplate restTemplate=new RestTemplate();
        
        restTemplate.getInterceptors().add((request, body, execution) -> {
        	//
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            
            return execution.execute(request, body);
        });
        //
        return restTemplate;
    }
}
