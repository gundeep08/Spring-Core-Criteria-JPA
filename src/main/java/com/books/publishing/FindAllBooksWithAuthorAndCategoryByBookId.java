package com.books.publishing;

import java.util.List;

import com.books.publishing.entities.Book;
import com.books.publishing.service.PublishingService;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindAllBooksWithAuthorAndCategoryByBookId {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithAuthorAndCategoryByBookId.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        Long idFind = 1L;
        logger.info("============== Find all books along with its author and its category Id by Book Id start ==============");
        Book book = publishingService.findAllBooksWithAuthorAndCategoryByBookId(idFind);
        logger.info(book.toString());
		
		if (book.getAuthor() != null) {
				book.getAuthor().forEach(a -> logger.info("\t" + a.toString()));
		}
		if (book.getCategory() != null) {
			logger.info("\t" + book.getCategory().toString());
		}
        logger.info("============== Find all books along with its author and its category Id by Book Id end ==============");
		
        ctx.close();
    }
}
