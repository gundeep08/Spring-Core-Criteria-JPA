package com.books.publishing;

import java.util.List;

import com.books.publishing.entities.Book;
import com.books.publishing.service.PublishingService;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindAllBooksWithSameAuthor {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithSameAuthor.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        Long idFind = 2L;
        logger.info("============== Find all books with the same author start ==============");
        List<Book> book = publishingService.findAllBooksForAuthorHavingMoreThan1Book(idFind);
        listBooks(book);
        logger.info("============== Find all books with the same author end ==============");
		
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books From Author with AuthorID of 2:");
		books.forEach(s -> logger.info(s.toString()));
	}
}
