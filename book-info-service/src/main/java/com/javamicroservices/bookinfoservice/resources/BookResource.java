package com.javamicroservices.bookinfoservice.resources;
import com.javamicroservices.bookinfoservice.models.BookSummary;
import com.javamicroservices.bookinfoservice.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/books")
public class BookResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId) {
        Random random = new Random();
        int randomNumber = random.nextInt(30);

        BookSummary bookSummary = restTemplate.getForObject("https://dummyjson.com/quotes/" + randomNumber, BookSummary.class);
        if (bookSummary != null) {
            return new Book(bookId, bookSummary.getTitle(), bookSummary.getAuthor());
        }
        return null;
    }
}
