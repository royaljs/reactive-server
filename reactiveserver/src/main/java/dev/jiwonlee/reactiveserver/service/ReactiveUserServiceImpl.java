package dev.jiwonlee.reactiveserver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jiwonlee.reactiveserver.entity.User;
import dev.jiwonlee.reactiveserver.repository.ReactiveUserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReactiveUserServiceImpl implements ReactiveUserService {

	private final ReactiveUserRepository userRepository;

	@Override
	public Mono<User> findUserById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	@Transactional
	public Mono<User> addUser(String name) {
		return userRepository.save(new User(name));
	}
}
