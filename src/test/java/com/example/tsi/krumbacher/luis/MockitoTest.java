package com.example.tsi.krumbacher.luis;

import com.example.tsi.krumbacher.luis.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) //inherit characteristics to use Mockito
public class MockitoTest {

    private SakilaDatabaseApplication sakilaDatabaseApplication;

    @Mock
    private LanguageRepository languageRepository;//create fake version of language repository to run mock tests

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

    @BeforeEach // create an instance of our database without data
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(languageRepository,
                filmRepository, categoryRepository, actorRepository, customerRepository, film_actorRepository, reviewRepository);
    }

    @Test
    public void testAddLanguage(){
        Language saveLanguage = new Language("test language"); //post request for mock database
        String expected = "save"; //response
        String actual = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture()); //verifying that repository has saved instance
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data not added to mock database");
    }

    @Test
    public void testGetLanguages(){
        Language lang1 = new Language("Spanish");
        Language lang2 = new Language("German");
        List<Language> languageList = new ArrayList<>();
        languageList.add(lang1);
        languageList.add(lang2);
        when(sakilaDatabaseApplication.getAllLanguages()).thenReturn(languageList);
        Assertions.assertEquals(languageList, sakilaDatabaseApplication.getAllLanguages(), "Languages data not in database.");
    }

    @Test
    public void testAddCustomer(){
        Customer saveCustomer = new Customer("John", "Smith", "JohnSmith@gmail.com"); //post request for mock database
        String expected = "save"; //response
        String actual = sakilaDatabaseApplication.addCustomer(saveCustomer.getFirst_name(), saveCustomer.getLast_name(), saveCustomer.getEmail());
        ArgumentCaptor<Customer>customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(customerArgumentCaptor.capture()); //verifying that repository has saved instance
        customerArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data not added to mock database");
    }

    @Test
    public void testGetCustomers(){
        Customer customer1 = new Customer("Tom", "Stones", "tomstones@gmail.com");
        Customer customer2 = new Customer("Charlotte", "Sterling", "charlottesterling@gmail.com");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        when(sakilaDatabaseApplication.getAllCustomers()).thenReturn(customerList);
        Assertions.assertEquals(customerList, sakilaDatabaseApplication.getAllCustomers(), "Languages data was not retreived from Language database table.");
    }


    @Test
    public void testAddFilm(){
        Film addedFilm = new Film("Batman: The Dark Knight", "Batman tries to kill the Joker", 2008, '3', 5.99, 10, 15.99,
                "PG");
        String expected = "save";
        String actual = sakilaDatabaseApplication.addFilm(addedFilm.getTitle(),addedFilm.getDescription(), addedFilm.getRelease_year(),
                addedFilm.getRental_duration(), addedFilm.getRental_rate(), addedFilm.getLength(), addedFilm.getReplacement_cost(),
                addedFilm.getRating());
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual,"Film data has not been entered into the mock database");
    }

    @Test
    public void testGetFilms(){
        Film film1 = new Film("Batman: The Dark Knight", "Batman tries to kill the Joker", 2008, 3, 5.99, 100, 15.99,
                "PG");
        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);
        when(sakilaDatabaseApplication.getAllFilm()).thenReturn(filmList);
        Assertions.assertEquals(filmList, sakilaDatabaseApplication.getAllFilm(), "Languages data was not retrieved from Language database table.");
    }

    @Test
    public void testGetCategory(){
        Category newCategory = new Category("new Category");
        Category newCategory2 = new Category("another Category");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(newCategory);
        categoryList.add(newCategory2);
        when(sakilaDatabaseApplication.getAllCategories()).thenReturn(categoryList);
        Assertions.assertEquals(categoryList, sakilaDatabaseApplication.getAllCategories(), "Category not available.");
    }

    @Test
    public void testGetActor(){
        Actor newActor = new Actor("New", "Actor");
        Actor newActor2 = new Actor("Another", "Actress");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(newActor);
        actorList.add(newActor2);
        when(sakilaDatabaseApplication.getAllActor()).thenReturn(actorList);
        Assertions.assertEquals(actorList, sakilaDatabaseApplication.getAllActor(), "Actor not in database.");
    }

    @Test
    public void testAddReview(){
        Review testReview = new Review(45,
                "test review"
                );
        String expectedAdd ="save";

        String actual = sakilaDatabaseApplication.addReview(45,testReview.getConsumer_review());

        ArgumentCaptor<Review>reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).save(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();

        Assertions.assertEquals(expectedAdd,actual,"Actor data hasn't been added to mock DB");

    }
    @Test
    public void testDeleteReviewByID(){
        Review deleteReview = new Review(2,
                "test review"
                );

        int id =5;
        String actual = sakilaDatabaseApplication.deleteReviewByID(id);
        String expected ="deleted";

        ArgumentCaptor<Integer>reviewArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(reviewRepository).deleteById(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual);
    }
}
