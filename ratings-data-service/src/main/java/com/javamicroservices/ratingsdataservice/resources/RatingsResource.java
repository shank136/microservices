package com.javamicroservices.ratingsdataservice.resources;


import com.javamicroservices.ratingsdataservice.models.Rating;
import com.javamicroservices.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/books/{bookId}")
    public Rating getBookRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }


}
