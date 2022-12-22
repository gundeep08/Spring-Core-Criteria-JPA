package com.books.publishing.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
    @Column(name = "ID")
    private Long id;

	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Book> books = new HashSet<>();

    @Column(name = "NAME")
    private String name;
    
    @Override
    public String toString() {
    	  return String.format("Category - id: %d, Name: %s", id, name);
    }
}