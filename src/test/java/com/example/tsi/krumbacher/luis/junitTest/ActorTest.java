package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Actor;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    private Actor actor = new Actor("Liam", "Neeson");

    private Actor newActor = new Actor();

    @Test
    public void test_getActorId(){
        assertEquals(0, newActor.getActor_id());
    }

    @Test
    void getFirst_name() {
        assertEquals("test failed", actor.getFirst_name(), "Liam");
    }

    @Test
    void setFirst_name() {
        actor.setFirst_name("Denzel");
        assertEquals("test failed", actor.getFirst_name(), "Denzel");
    }

    @Test
    void getLast_name() {
        assertEquals("test failed", actor.getLast_name(), "Neeson");
    }

    @Test
    void setLast_name() {
        actor.setLast_name("Washington");
        assertEquals("test failed", actor.getLast_name(), "Washington");
    }
}