package com.books.publishing.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "FIRST_NAME")
    private String first_name;
    
    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany( cascade = {
	        CascadeType.ALL
	    },
			fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Book> books = new HashSet<>();
    

    public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

    public Author() {
    }

    public Long getId() {
        return this.id; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Author - id: %d, FirstName: %s, LastName: %s, Description: %s",
                id, first_name, last_name, description);
    }
}
