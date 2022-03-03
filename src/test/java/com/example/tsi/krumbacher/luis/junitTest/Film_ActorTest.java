package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Film_Actor;
import com.example.tsi.krumbacher.luis.demo.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Film_ActorTest {

    private Film_Actor filmActor = new Film_Actor(21,33);

    @Test
    void getFilm_id() {
        assertEquals(21, filmActor.getFilm_id(), "test failed");
    }

    @Test
    void setFilm_id() {
        filmActor.setFilm_id(44);
        assertEquals(44, filmActor.getFilm_id(), "test failed");
    }

    @Test
    void getActor_id() {
        assertEquals(33, filmActor.getActor_id(), "test failed");
    }

    @Test
    void setActor_id() {
        filmActor.setActor_id(56);
        assertEquals(56, filmActor.getActor_id(), "message");
    }
}