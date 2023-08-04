package com.javamicroservices.bookcatalogservice.resources;

import com.javamicroservices.bookcatalogservice.models.Book;
import com.javamicroservices.bookcatalogservice.models.CatalogItem;
import com.javamicroservices.bookcatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    System.out.println(rating.toString());
                    Book book = restTemplate.getForObject("http://book-info-service/books/" + rating.getBookId(), Book.class);
                    return new CatalogItem(book.getName(), book.getAuthor(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}