package com.books.publishing;

import java.util.List;
import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.books.publishing.entities.Book;
import com.books.publishing.service.PublishingService;

/**
 * This application finds all books by a native query.
 *
 */
public class FindAllBooksUsingNativeQuery {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooksUsingNativeQuery.class);
			
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

		PublishingService singerService = ctx.getBean(PublishingService.class);
		logger.info("============== Find all books without any details on its author and category using native query start ==============");
        List<Book> books = singerService.findAllByNativeQuery();
        listBooks(books);
        logger.info("============== Find all books without any details on its author and category using native query ends ==============");
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing all books details fetched using native query:");
		books.forEach(s -> logger.info(s.toString()));
	}
}
