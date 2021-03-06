package dev.jiwonlee.reactiveserver.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private Long id;

	private String name;

	public User(String name) {
		this.name = name;
	}
}
