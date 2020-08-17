package com.dxctraining.consoleapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Author {
	
	@Id
	@GeneratedValue
	private String id;
	private String name;

	public Author(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Book)) {
			return false;
		}

		Author that = (Author) arg;
		boolean isequal = this.id == that.id;
		return isequal;
	}

	@Override
	public String hashCode() {
	return id;
	}
}