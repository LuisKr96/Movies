package com.example.tsi.krumbacher.luis.demoTest;

import com.example.tsi.krumbacher.luis.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class addReviewStepDef {
    private SakilaDatabaseApplication sakilaDatabaseApplication;

    @Mock
    private LanguageRepository languageRepository;

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ActorRepository actorRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private Film_ActorRepository film_actorRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    void setup(){
        languageRepository = mock(LanguageRepository.class);
        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);
        customerRepository = mock(CustomerRepository.class);
        film_actorRepository = mock(Film_ActorRepository.class);
        reviewRepository = mock(ReviewRepository.class);
        sakilaDatabaseApplication = new SakilaDatabaseApplication(languageRepository, filmRepository, categoryRepository,
                actorRepository,customerRepository, film_actorRepository, reviewRepository);
    }

    //Add Review
   String actualReview;
    Review savedReview;

    @Given("I enter a film Id and review")
    public void i_enter_a_film_id_and_review() {
        setup();
        savedReview = new Review(5, "terrible");
    }
    @When("The review is saved")
    public void the_review_is_saved() {
        actualReview = sakilaDatabaseApplication.addReview(savedReview.getFilm_id(), savedReview.getConsumer_review());
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).save(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();
    }
    @Then("I get a return save")
    public void i_get_a_return_save() {
        String expected = "save";
        Assertions.assertEquals(expected, actualReview, "test failed");
    }

    //Delete Review
    int reviewId;

    @Given("I enter a review ID")
    public void i_enter_a_review_id() {
        setup();
        reviewId = 69;
    }
    @When("I delete the review")
    public void i_delete_the_review() {
        actualReview = sakilaDatabaseApplication.deleteReviewByID(69);
        ArgumentCaptor<Integer>reviewArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(reviewRepository).deleteById(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();
    }
    @Then("I get a return deleted")
    public void i_get_a_return_deleted() {
        String expected = "deleted";
        Assertions.assertEquals(expected, actualReview, "test failed");
    }

    //Get films

    List<Film> films = new ArrayList<>();

    @Given("The website has a list of films")
    public void the_website_has_a_list_of_films() {
        setup();
        Film film1 = new Film("Batman: The Dark Knight", "Batman tries to kill the Joker", 2008, 3, 5.99, 100, 15.99,
                "PG");
        Film film2 = new Film("Batman: The Dark Knight", "Batman tries to kill the Joker", 2008, 3, 5.99, 100, 15.99,
                "PG");

        films.add(film1);
        films.add(film2);
    }
    @When("I go to the website")
    public void i_go_to_the_website() {
        when(sakilaDatabaseApplication.getAllFilm()).thenReturn(films);
    }

    @Then("The films should appear")
    public void the_films_should_appear() {
        Assertions.assertEquals(films, sakilaDatabaseApplication.getAllFilm(), "no films");
    }

}
