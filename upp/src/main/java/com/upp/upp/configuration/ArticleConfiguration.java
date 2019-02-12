package com.upp.upp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.upp.upp.client.ArticleClient;

@Configuration
public class ArticleConfiguration {

	@Bean
	public Jaxb2Marshaller locationMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.upp.upp.requestAndresponse");
		
		return marshaller;
	}
	@Bean
	public ArticleClient arrangmentClient(Jaxb2Marshaller marshaller) {
		ArticleClient client = new ArticleClient();
		client.setDefaultUri("http://localhost:8082/Service/ArticleWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
