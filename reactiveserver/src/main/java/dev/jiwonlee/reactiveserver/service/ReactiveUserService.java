package dev.jiwonlee.reactiveserver.service;

import dev.jiwonlee.reactiveserver.entity.User;
import reactor.core.publisher.Mono;

public interface ReactiveUserService {
	Mono<User> findUserById(Long userId);
	Mono<User> addUser(String name);
}
