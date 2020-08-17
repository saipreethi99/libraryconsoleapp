package com.dxctraining.consoleapp.ui;

import com.dxctraining.consoleapp.entities.Author;
import com.dxctraining.consoleapp.entities.Book;
import com.dxctraining.consoleapp.exceptions.BookNotFoundException;
import com.dxctraining.consoleapp.exceptions.InvalidArgumentException;
import com.dxctraining.consoleapp.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BookUi {
	@Autowired
	private IBookService service;

	@PostConstruct
	public void runUi() {
		try {
			Author author1 = new Author("1", "preethi");
			Author author2 = new Author("2", "sai");
			Book book1 = new Book("book1", 222.55, author1);
			Book book2 = new Book("book2", 333.44, author2);

			service.add(book1);
			service.add(book2);

			int id1 = book1.getId();
			Book fetched1 = service.findById(id1);
			System.out.println(
					"fetcehd book =" + fetched1.getName() + " " + fetched1.getCost() + " " + fetched1.getAuthor());

		} catch (BookNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidArgumentException e) {
			e.printStackTrace();
		}
	}

}