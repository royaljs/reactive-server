package dev.jiwonlee.remoteserver.service;

import dev.jiwonlee.remoteserver.entity.User;

public interface BlockingUserService {
	User findUserById(Long userId) throws Exception;

	User addUser(String name);
}
