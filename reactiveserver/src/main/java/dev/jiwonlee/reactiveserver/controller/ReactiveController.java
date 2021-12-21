package dev.jiwonlee.reactiveserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.jiwonlee.reactiveserver.service.ReactiveService;

@CrossOrigin("*")
@RestController
public class ReactiveController {

	private ReactiveService reactiveService;

	@Autowired
	public ReactiveController(ReactiveService reactiveService) {
		this.reactiveService = reactiveService;
	}

	@GetMapping("/rest-template")
	public ResponseEntity restTemplate() throws Exception {
		return ResponseEntity.ok().body(reactiveService.restTemplate());
	}

	@GetMapping("/async-rest-template")
	public ResponseEntity asyncRestTemplate() throws Exception {
		return ResponseEntity.ok().body(reactiveService.asyncRestTemplate());
	}

	@GetMapping("/future")
	public ResponseEntity future() throws Exception {
		return ResponseEntity.ok().body(reactiveService.future());
	}

	@GetMapping("/completable-future")
	public ResponseEntity completableFuture() throws Exception {
		return ResponseEntity.ok().body(reactiveService.completableFuture());
	}

	@GetMapping("/listenable-future")
	public ResponseEntity listenableFuture() throws Exception {
		return ResponseEntity.ok().body(reactiveService.listenableFuture());
	}

	@GetMapping("/defered-result")
	public ResponseEntity deferedResult() throws Exception {
		return ResponseEntity.ok().body(reactiveService.deferedResult());
	}

	@GetMapping("/webclient")
	public ResponseEntity webclient() throws Exception {
		return ResponseEntity.ok().body(reactiveService.webclient());
	}

}
