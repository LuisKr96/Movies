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
        assertEquals("Liam", actor.getFirst_name(), "test failed");
    }

    @Test
    void setFirst_name() {
        actor.setFirst_name("Denzel");
        assertEquals("Denzel", actor.getFirst_name(), "test failed");
    }

    @Test
    void getLast_name() {
        assertEquals("Neeson", actor.getLast_name(), "test failed");
    }

    @Test
    void setLast_name() {
        actor.setLast_name("Washington");
        assertEquals("Washington", actor.getLast_name(), "test failed");
    }
}