package dev.jiwonlee.reactiveserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfiguration {

	@Value("${remote.server.url}")
	private String remoteServerUrl;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(remoteServerUrl);
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(3000);
		requestFactory.setReadTimeout(3000);
		restTemplate.setRequestFactory(requestFactory);

		return restTemplate;
	}

}
