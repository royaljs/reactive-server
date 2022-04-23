package dev.jiwonlee.reactiveserver.service;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import reactor.core.publisher.Mono;

public interface ReactiveService {

    /**
     * RestTemplate
     * Blocking 방식의 외부 서비스 호출
     */
    public ResponseEntity<String> restTemplate();

    /**
     * AsyncRestTemplate
     * Blocking 방식의 외부 서비스 호출
     */
    public ListenableFuture<ResponseEntity<String>> asyncRestTemplate();

    /**
     * Future
     * RestTemplate을 이용하여 외부 서비스 호출
     * @return
     * @throws Exception
     */
    public ResponseEntity<String> future() throws Exception;

    public ResponseEntity<String> completableFuture() throws Exception;

    public String listenableFuture();

    public String deferedResult();

    /**
     * WebClient
     * Non-blocking 방식의 외부 서비스 호출
     */
    public Mono<String> webclient();

}
