package com.books.publishing;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.books.publishing.entities.Author;
import com.books.publishing.entities.Book;
import com.books.publishing.service.PublishingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertBookAuthorToExistingCategory {
	private static Logger logger = LoggerFactory.getLogger(
		InsertBookAuthorToExistingCategory.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        Long idFind = 1L;
        PublishingService publishingService = ctx.getBean(PublishingService.class);
		
        logger.info("============== Insert Book with new Author to existing category start ==============");
		Book book = new Book();
		book.setIsbn("5555");
		book.setPrice(50);
		book.setTitle("JPA Guide to Glory");
		Book anotherBookFromSameCategory = publishingService.findAllBooksWithAuthorAndCategoryByBookId(idFind);
		book.setCategory(anotherBookFromSameCategory.getCategory());
	
		Set<Author> authorSet= new HashSet<>();
		Author author = new Author();
		author.setDescription("ORM Specialist");
		author.setFirst_name("Vitalik");
		author.setLast_name("Yurik");
		authorSet.add(author);
		book.setAuthor(authorSet);
		publishingService.save(book);
		logger.info("============== Find all books including new one along with its author and its category details start ==============");    
		Book newBook = publishingService.findNewlyAddedBook();
		logger.info(newBook.toString());
		
		if (newBook.getAuthor() != null) {
			newBook.getAuthor().forEach(a -> logger.info("\t" + a.toString()));
		}
		if (newBook.getCategory() != null) {
			logger.info("\t" + newBook.getCategory().toString());
		}
		logger.info("============== Find all books including new one along with its author and its category details end ==============");    
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books including the newly added along with its autor and category details:");
		books.forEach(b -> {
			logger.info(b.toString());
			if (b.getAuthor() != null) {
				b.getAuthor().forEach(a -> logger.info("\t" + a.toString()));
			}
			if (b.getCategory() != null) {
				logger.info("\t" + b.getCategory().toString());
			}
		});
   }
   
}
