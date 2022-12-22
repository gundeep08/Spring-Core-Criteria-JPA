package com.books.publishing.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name=Book.FIND_ALL_WITHOUT_CATEGORY_AND_AUTHOR, query="select b from Book b"),
		
		 @NamedQuery(name=Book.FIND_ALL_WITH_CATEGORY_AND_AUTHOR,
		 query="select b from Book b " + "left join fetch b.author a " +
		  "left join fetch b.category c"),
		 
		 @NamedQuery(name=Book.FIND_ALL_WITH_CATEGORY_AND_AUTHOR_BY_BOOK_ID,
		 query="select b from Book b " + "left join fetch b.author a " +
		  "left join fetch b.category c " + "where b.id = :id"),
		 
        @NamedQuery(name=Book.FIND_ALL_BOOKS_BY_AUTHOR_ID,
		 query="select b from Book b " + "left join fetch b.author a " 
          + "where a.id = :id"),
        
        @NamedQuery(name=Book.FIND_NEWLY_ADDED_BOOK_ID,
		 query="select max(b.id) from Book b")
})
@SqlResultSetMapping(
     name="bookResult",
     entities=@EntityResult(entityClass=Book.class)
)
public class Book implements Serializable {

    public static final String FIND_ALL_WITHOUT_CATEGORY_AND_AUTHOR = "Book.findAll";
    public static final String FIND_ALL_WITH_CATEGORY_AND_AUTHOR = "Book.findAllBooksWithCategoryAndAuthor";
    public static final String FIND_ALL_WITH_CATEGORY_AND_AUTHOR_BY_BOOK_ID = 
    		"Book.findAllBooksWithCategoryAndAuthorById";
    public static final String FIND_ALL_WITH_ALBUM_INSTRUMENT = 
    		"Singer.findAllWithAlbumInstrument";
    public static final String FIND_ALL_BOOKS_BY_AUTHOR_ID = "Book.findAllWithAuthorHavingMoreThan1Book";
    public static final String FIND_NEWLY_ADDED_BOOK = "Book.newlyAddedBook";
    public static final String FIND_NEWLY_ADDED_BOOK_ID = "Book.newlyAddedBookId";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "PRICE")
    private float price;
    

	public Set<Author> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@ManyToMany( cascade = {
	        CascadeType.ALL
	    },
			fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private Set<Author> author = new HashSet<>();


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category Id: " + category.getId()
            + ", ISBN: " + isbn + ", Price: " + price + ", Title: " + title;
    }
}
