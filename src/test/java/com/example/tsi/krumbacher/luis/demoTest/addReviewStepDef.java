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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
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

    //Get reviews

    List<Review> reviews = new ArrayList<>();

    @Given("The films have reviews")
    public void the_films_have_reviews() {
        Review review1 = new Review(5,"new review");
        Review review2 = new Review(34, "another review");
        Review review3 = new Review(23,"final review");
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
    }
    @When("I go to the website")
    public void i_go_to_the_website() {
        when(sakilaDatabaseApplication.getAllReviews()).thenReturn(reviews);
    }
    @Then("The the reviews should appear")
    public void the_the_reviews_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
