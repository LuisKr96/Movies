package com.example.tsi.krumbacher.luis.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    private int film_id;
    private String consumer_review;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", updatable = false, insertable = false)
    private Film film;



    public Review(int film_id,String consumer_review){

        this.film_id=film_id;
        this.consumer_review=consumer_review;

    }

    public Review(){

    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public String getConsumer_review() {
        return consumer_review;
    }

    public void setConsumer_review(String consumer_review) {
        this.consumer_review = consumer_review;
    }

}
