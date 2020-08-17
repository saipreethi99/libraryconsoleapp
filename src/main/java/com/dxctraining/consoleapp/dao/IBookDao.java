package com.dxctraining.consoleapp.dao;

import java.util.List;

import com.dxctraining.consoleapp.entities.Book;

public interface IBookDao {

	Book findById(int id);

	Book update(Book book);

	void add(Book book);

	Book updateCost(int id, double cost);

	void remove(int id);

}