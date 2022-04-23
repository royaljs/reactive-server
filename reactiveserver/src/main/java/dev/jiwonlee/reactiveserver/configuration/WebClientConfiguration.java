package dev.jiwonlee.reactiveserver.configuration;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.LoggingCodecSupport;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class WebClientConfiguration {

	@Value("${remote.server.url}")
	private String remoteServerUrl;

	@Bean
	public WebClient webClient() {
		int maxConnections = 1000;

		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
			.codecs(configurer -> configurer.defaultCodecs()
				.maxInMemorySize(1024 * 1024 * 500))
			.build();
		exchangeStrategies
			.messageWriters().stream()
			.filter(LoggingCodecSupport.class::isInstance)
			.forEach(writer -> ((LoggingCodecSupport)writer).setEnableLoggingRequestDetails(true));

		return WebClient.builder()
			.baseUrl(remoteServerUrl)
			.clientConnector(
				new ReactorClientHttpConnector(
					HttpClient.create(ConnectionProvider.builder("fixed")
						.maxConnections(maxConnections)
						.maxIdleTime(Duration.ofSeconds(20))
						.maxLifeTime(Duration.ofSeconds(60))
						.pendingAcquireTimeout(
							Duration.ofSeconds(120))
						.evictInBackground(
							Duration.ofSeconds(120))
						.build())))
			.exchangeStrategies(exchangeStrategies)
			.filter(ExchangeFilterFunction.ofRequestProcessor(
				clientRequest -> Mono.just(clientRequest)))
			.filter(ExchangeFilterFunction.ofResponseProcessor(
				clientResponse -> Mono.just(clientResponse)))
			.build();
	}

}
