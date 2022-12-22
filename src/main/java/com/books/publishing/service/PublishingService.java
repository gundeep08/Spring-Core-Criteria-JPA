package com.books.publishing.service;

import java.util.List;
import com.books.publishing.entities.Book;

public interface PublishingService {
	List<Book> findAllBooksWithoutAuthorAndCategory();
    List<Book> findAllBooksWithAuthorAndCategory();
    List<Book> findAllBooksForAuthorHavingMoreThan1Book(long id);
    Book findAllBooksWithAuthorAndCategoryByBookId(long id);
    Book save(Book book);
    void deleteBook(Book book);
    Book findNewlyAddedBook();
    List<Book> findAllByNativeQuery();
}
