package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Film;
import com.example.tsi.krumbacher.luis.demo.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {
    private Review review = new Review(1,"really good movie");

    @Test
    void getFilm_id() {
        assertEquals(1,review.getFilm_id());
    }

    @Test
    void setFilm_id() {
        review.setFilm_id(2);
        assertEquals(2, review.getFilm_id());
    }

    @Test
    void getConsumer_review() {
        assertEquals("really good movie", review.getConsumer_review(), "test failed");
    }

    @Test
    void setConsumer_review() {
        review.setConsumer_review("terrible");
        assertEquals("terrible", review.getConsumer_review(), "test failed");
    }
}