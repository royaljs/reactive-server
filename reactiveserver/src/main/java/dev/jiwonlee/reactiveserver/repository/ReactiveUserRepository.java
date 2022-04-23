package dev.jiwonlee.reactiveserver.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import dev.jiwonlee.reactiveserver.entity.User;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveUserRepository extends ReactiveCrudRepository<User, Long> {
	Mono<User> findById(Long userId);
}
