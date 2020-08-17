package com.dxctraining.consoleapp.service;

import java.util.List;

import com.dxctraining.consoleapp.dao.IBookDao;
import com.dxctraining.consoleapp.entities.Book;
import com.dxctraining.consoleapp.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao dao;

	public Book findById(int id) {
		
		Book book = dao.findById(id);
		return book;
	}

	@Override
	public void add(Book book) {
		checkBook(book);
		dao.add(book);

	}

	private void checkBook(Book book) {
		if (book == null) {
			throw new InvalidArgumentException("book can not be null");
		}
	}

	@Override
	public void remove(int id) {
		dao.remove(id);

	}

	@Override
	public Book updateCost(int id, double cost) {
	
		Book book = dao.updateCost(id, cost);
		return book;
	}

	@Override
	public Book update(Book book) {
		validate(book);
		book = dao.update(book);
		return book;

	}

	
	public void validate(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}
	}
}