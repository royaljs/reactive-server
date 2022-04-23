package dev.jiwonlee.remoteserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jiwonlee.remoteserver.entity.User;

@Repository
public interface BlockingUserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long userId);
}
