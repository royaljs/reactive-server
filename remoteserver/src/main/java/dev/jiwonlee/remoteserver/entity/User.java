package dev.jiwonlee.remoteserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
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
