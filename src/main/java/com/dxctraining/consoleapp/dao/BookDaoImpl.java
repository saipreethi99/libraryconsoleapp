package com.dxctraining.consoleapp.dao;

import org.springframework.stereotype.Repository;
import com.dxctraining.consoleapp.entities.Book;
import com.dxctraining.consoleapp.exceptions.BookNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDaoImpl implements IBookDao{

    @PersistenceContext
    private EntityManager entityManager;
 

    @Override
    public Book findById(int id) {
        Book book=entityManager.find(Book.class,id);
        if(book==null){
            throw new BookNotFoundException("book not found for id="+id);
        }
        return book;
    }

    @Override
    public Book update(Book book) {
        book=entityManager.merge(book);
        return book;
    }

    @Override
    public void add(Book book) {
        entityManager.persist(book);
        
    }
    
    @Override
    public void remove(int id) {
     Book book= findById(id) ;
     entityManager.remove(book);
    }
    

	@Override
	public Book updateCost(int id, double cost) {
		 Book book= findById(id) ;
	      entityManager.merge(cost);
		return book;
	}

}