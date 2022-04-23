package dev.jiwonlee.reactiveserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jiwonlee.reactiveserver.service.ReactiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ReactiveController {

	private final ReactiveService reactiveService;

	@GetMapping("/")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Hello World!");
	}

	@GetMapping("/rest-template")
	public ResponseEntity<String> restTemplate() throws Exception {
		return reactiveService.restTemplate();
	}

	@GetMapping("/async-rest-template")
	public ListenableFuture<ResponseEntity<String>> asyncRestTemplate() throws Exception {
		return reactiveService.asyncRestTemplate();
	}

	@GetMapping("/future")
	public ResponseEntity<String> future() throws Exception {
		return reactiveService.future();
	}

	@GetMapping("/completable-future")
	public ResponseEntity<String> completableFuture() throws Exception {
		return reactiveService.completableFuture();
	}

	@GetMapping("/listenable-future")
	public ResponseEntity<String> listenableFuture() throws Exception {
		return ResponseEntity.ok().body(reactiveService.listenableFuture());
	}

	@GetMapping("/defered-result")
	public ResponseEntity<String> deferedResult() throws Exception {
		return ResponseEntity.ok().body(reactiveService.deferedResult());
	}

	@GetMapping("/webclient")
	public Mono<ResponseEntity<String>> webclient() throws Exception {
		return reactiveService.webclient().map(data -> ResponseEntity.ok().body(data));
	}

}
