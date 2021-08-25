package com.barclays.assignment.librarymManagementSystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {

	private Long id;

	private String isbn;

	private String name;

	private String serialName;

	private String description;


	public Book(Long id, String isbn, String name, String serialName, String description) {
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.serialName = serialName;
		this.description = description;
	}
}
