package com.books.publishing;

import java.util.List;

import com.books.publishing.entities.Book;
import com.books.publishing.service.PublishingService;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindAllBooksWithAuthorAndCategory {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithAuthorAndCategory.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        logger.info("============== Find all books along with its author and its category details start ==============");
        List<Book> books = publishingService.findAllBooksWithAuthorAndCategory();
        listBooks(books);
        logger.info("============== Find all books along with its author and its category details end ==============");
		
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books with its autor and category details:");
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
