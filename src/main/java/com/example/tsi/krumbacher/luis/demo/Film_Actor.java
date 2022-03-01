package com.example.tsi.krumbacher.luis.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film_Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private int actor_id;


    public Film_Actor(int film_id, int actor_id){
        this.film_id= film_id;
        this.actor_id=actor_id;

    }

    public Film_Actor(){

    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
}

