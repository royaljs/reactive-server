package dev.jiwonlee.reactiveserver.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
	HttpClient httpClient() {
		return HttpClientBuilder.create()
				.setMaxConnTotal(1000)
				.setMaxConnPerRoute(1000)
				.build();
	}

	@Bean
	HttpComponentsClientHttpRequestFactory factory(HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(3000);
		factory.setConnectTimeout(3000);
		factory.setHttpClient(httpClient);

		return factory;
	}

	@Bean
	DefaultUriBuilderFactory uriBuilderFactory() {
		return new DefaultUriBuilderFactory(remoteServerUrl);
	}

	@Bean
	public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory requestFactory,
			DefaultUriBuilderFactory uriBuilderFactory) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		requestFactory.setConnectTimeout(3000);
		requestFactory.setReadTimeout(3000);
		restTemplate.setRequestFactory(requestFactory);

		return restTemplate;
	}

}
