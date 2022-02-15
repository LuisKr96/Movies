package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FilmTest {

    private Film filmTest = new Film("Batman: The Dark Knight", "Batman tries to kill the Joker", 2008, 3, 5.99, 100, 15.99,
            "PG");

    @Test
    public void test_getFilm(){
        filmTest.setTitle("film test");
        assertEquals("this test failed", filmTest.getTitle(), "film test");

    }
//    @Test
//    public void test_getFilm_id() {
//        assertEquals("test failed", filmTest.getFilm_id());
//    }

    @Test
    public void test_getTitle() {
        assertEquals("Test failed", "Batman: The Dark Knight", filmTest.getTitle());
    }

    @Test
    public void test_setTitle() {
        filmTest.setTitle("New title");
        assertEquals("Test failed","New title",filmTest.getTitle());
    }

    @Test
    public void test_getDescription() {
        assertEquals("Test failed", "Batman tries to kill the Joker", filmTest.getDescription());
    }

    @Test
    public void test_setDescription() {
        filmTest.setDescription("New Description");
        assertEquals("Test failed", "New Description", filmTest.getDescription());
    }

    @Test
    public void test_getRelease_year() {
        assertEquals("Test failed", 2008, filmTest.getRelease_year());
    }

    @Test
    public void test_setRelease_year() {
        filmTest.setRelease_year(2000);
        assertEquals("Test failed", 2000, filmTest.getRelease_year());
    }

    @Test
    public void test_getRental_duration() {
        assertEquals("Test failed", 3, filmTest.getRental_duration());
    }

    @Test
    public void test_setRental_duration() {
        filmTest.setRental_duration(5);
        assertEquals("Test failed", 5, filmTest.getRental_duration());
    }

    @Test
    public void test_getRental_rate() {
        Assertions.assertEquals(filmTest.getRental_rate(), 5.99, "Test failed");
    }

    @Test
    public void test_setRental_rate() {
        filmTest.setRental_rate(10.76);
        Assertions.assertEquals(filmTest.getRental_rate(), 10.76, "Test failed");
    }

    @Test
    public void test_getLength() {
        assertEquals("Test failed", 100, filmTest.getLength());
    }

    @Test
    public void test_setLength() {
        filmTest.setLength(79);
        assertEquals("Test failed", 79, filmTest.getLength());
    }

    @Test
    public void test_getReplacement_cost() {
        Assertions.assertEquals(15.99, filmTest.getReplacement_cost(), "Test failed");
    }

    @Test
    public void test_setReplacement_cost() {
        filmTest.setReplacement_cost(345.65);
        Assertions.assertEquals(345.65, filmTest.getReplacement_cost(), "Test failed");
    }

    @Test
    public void test_getRating() {
        assertEquals("Test failed", filmTest.getRating(), "PG");
    }

    @Test
    public void test_setRating() {
        filmTest.setRating("18");
        assertEquals("Test failed", filmTest.getRating(), "18");
    }
}
