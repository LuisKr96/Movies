package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Film;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilmTest {

    private Film filmTest = new Film();

    @Test
    public void test_getFilm(){
        filmTest.setTitle("film test");
        assertEquals("this test failed", filmTest.getTitle(), "film test");

    }
}
