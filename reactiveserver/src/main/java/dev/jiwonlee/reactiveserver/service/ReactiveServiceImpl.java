package dev.jiwonlee.reactiveserver.service;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactiveServiceImpl implements ReactiveService {

    private final RestTemplate restTemplate;
    private final AsyncRestTemplate asyncRestTemplate;
    private final WebClient webClient;

    @Override
    public ResponseEntity<String> restTemplate() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> request = new HttpEntity<>(header);
        return restTemplate
                .exchange(
                        "/",
                        HttpMethod.GET,
                        request,
                        String.class);
    }

    @Override
    public ListenableFuture<ResponseEntity<String>> asyncRestTemplate() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> request = new HttpEntity<>(header);
        ListenableFuture<ResponseEntity<String>> responseDto = asyncRestTemplate
                .exchange(
                        "/",
                        HttpMethod.GET,
                        request,
                        String.class);
        responseDto.addCallback(data -> log.info(String.valueOf(data)), e -> log.info(
            Arrays.toString(e.getStackTrace())));
        return responseDto;
    }

    @Override
    public ResponseEntity<String> future() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        return executor.submit(this::restTemplate).get(); //Future의 get()이 호출되는 쓰레드는 blocking됨
    }

    @Override
    public String listenableFuture() {
        return null;
    }

    @Override
    public String deferedResult() {
        return null;
    }

    @Override
    public ResponseEntity<String> completableFuture() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<ResponseEntity<String>> completableFuture = CompletableFuture.supplyAsync(this::restTemplate, executor);
        return completableFuture.get();
    }

    @Override
    public Mono<String> webclient() {
        Mono<String> res = webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class);
        return res;
    }
}
