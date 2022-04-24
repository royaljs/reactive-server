package dev.jiwonlee.remoteserver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jiwonlee.remoteserver.entity.User;
import dev.jiwonlee.remoteserver.repository.BlockingUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlockingUserServiceImpl implements BlockingUserService {
	private final BlockingUserRepository userRepository;

	@Override
	public User findUserById(Long userId) throws Exception {
		return userRepository.findById(userId).orElseThrow(Exception::new);
	}

	@Override
	@Transactional
	public User addUser(String name) {
		return userRepository.save(new User(name));
	}
}
