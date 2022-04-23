package dev.jiwonlee.reactiveserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.jiwonlee.reactiveserver.controller.dto.UserDto;
import dev.jiwonlee.reactiveserver.entity.User;
import dev.jiwonlee.reactiveserver.service.ReactiveUserService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReactiveUserController {
	private final ReactiveUserService userService;

	@GetMapping("/users/{userId}")
	public Mono<User> findUserById(@PathVariable Long userId){
		return userService.findUserById(userId);
	}

	@PostMapping("/users")
	public Mono<User> addUser(@RequestBody UserDto request){
		return userService.addUser(request.getName());
	}
}
