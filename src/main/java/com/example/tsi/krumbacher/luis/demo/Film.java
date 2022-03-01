package com.example.tsi.krumbacher.luis.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    private String title;
    private String description;
    private int release_year;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private String rating;



    public Film(String title, String description, int release_year, int rental_duration, double rental_rate, int length, double replacement_cost, String rating){
        this.title=title;
        this.description=description;
        this.release_year=release_year;
        this.rental_duration=rental_duration;
        this.rental_rate=rental_rate;
        this.length=length;
        this.replacement_cost=replacement_cost;
        this.rating=rating;

    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})

    private Set<Actor> actor = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_category",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "category_id",
                            nullable = false, updatable = false)})
    private Set<Category> category = new HashSet<>();




    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Set<Actor> getActors() {
        return actor;
    }

    public void setActors(Set<Actor> actor) {
        this.actor = actor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    public Film(){}

    public int getFilm_id(){return film_id;}

    public String getTitle(){return title;}

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
