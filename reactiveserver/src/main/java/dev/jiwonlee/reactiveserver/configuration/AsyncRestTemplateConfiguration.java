package dev.jiwonlee.reactiveserver.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class AsyncRestTemplateConfiguration {

	@Autowired
	private DefaultUriBuilderFactory uriBuilderFactory;

	@Bean
	public AsyncRestTemplate asyncRestTemplate(DefaultUriBuilderFactory uriBuilderFactory){
	  AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
	  asyncRestTemplate.setAsyncRequestFactory(new Netty4ClientHttpRequestFactory());
	  asyncRestTemplate.setUriTemplateHandler(uriBuilderFactory);
	  return asyncRestTemplate;
	}

}
