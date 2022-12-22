package com.books.publishing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.books.publishing.entities.Book;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service("jpaBookPublishingService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PublishingServiceImpl implements PublishingService {
    final static String ALL_BOOKS_NATIVE_QUERY =
        "select id, category_id, isbn, title, price from book";

    private static Logger logger = LoggerFactory.getLogger(PublishingServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllBooksWithAuthorAndCategory() {
        return em.createNamedQuery(Book.FIND_ALL_WITH_CATEGORY_AND_AUTHOR, Book.class).getResultList();
    }
    
    @Transactional(readOnly=true)
    @Override
    public Book findAllBooksWithAuthorAndCategoryByBookId(long id) {
    	  TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL_WITH_CATEGORY_AND_AUTHOR_BY_BOOK_ID, 
          		Book.class);
          query.setParameter("id", id);
          return query.getSingleResult();
    }
    
    @Transactional(readOnly=true)
    @Override
    public Book findNewlyAddedBook() {
    	TypedQuery<Long> query_id = em.createNamedQuery(Book.FIND_NEWLY_ADDED_BOOK_ID, Long.class);
    	long id= query_id.getSingleResult();
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL_WITH_CATEGORY_AND_AUTHOR_BY_BOOK_ID, 
            		Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
  
    
    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllBooksForAuthorHavingMoreThan1Book(long id) {
    	TypedQuery<Book> query =  em.createNamedQuery(Book.FIND_ALL_BOOKS_BY_AUTHOR_ID, Book.class);
    	query.setParameter("id", id);
    	return query.getResultList();
    }
    
    
    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllBooksWithoutAuthorAndCategory() {
        return em.createNamedQuery(Book.FIND_ALL_WITHOUT_CATEGORY_AND_AUTHOR, Book.class).getResultList();
    }
   

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            logger.info("Inserting new book");
            em.persist(book);
        } else {
            em.merge(book);
            logger.info("Updating existing book");
        }
        logger.info("Book saved with id: " + book.getId());

        return book;
    }

    @Override
    public void deleteBook(Book book) {
        Book mergedContact = em.merge(book);
        em.remove(mergedContact);
        em.flush();
        logger.info("Book with id: " + book.getId()  + " deleted successfully");
    }
    


    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_BOOKS_NATIVE_QUERY, "bookResult").getResultList();
    }
   
}
