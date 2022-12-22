package com.books.publishing;

import java.util.List;

import com.books.publishing.entities.Book;
import com.books.publishing.service.PublishingService;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindAllBooksWithoutAuthorAndCategory {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithoutAuthorAndCategory.class);

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();

		PublishingService publishingService = ctx.getBean(PublishingService.class);

		logger.info("============== Find all books without any details on its author and category start ==============");
		List<Book> books = publishingService.findAllBooksWithoutAuthorAndCategory();
		listBooks(books);
		logger.info("============== Find all books without any details on its author and category end ==============");

		ctx.close();
	}

	public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books:");
		books.forEach(s -> logger.info(s.toString()));
	}
}
