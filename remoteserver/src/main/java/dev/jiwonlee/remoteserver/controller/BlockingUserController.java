package dev.jiwonlee.remoteserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.jiwonlee.remoteserver.controller.dto.UserDto;
import dev.jiwonlee.remoteserver.entity.User;
import dev.jiwonlee.remoteserver.service.BlockingUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlockingUserController {
	private final BlockingUserService userService;

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Long userId) throws Exception {
		User user = userService.findUserById(userId);
		return ResponseEntity.ok().body(new UserDto(user.getId(), user.getName()));
	}

	@PostMapping("/users")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto request) {
		User user = userService.addUser(request.getName());
		return ResponseEntity.ok().body(new UserDto(user.getId(), user.getName()));
	}
}
