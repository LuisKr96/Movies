package com.example.tsi.krumbacher.luis;

import com.example.tsi.krumbacher.luis.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class) //inherit characteristics to use Mockito
public class MockitoTest {

    private SakilaDatabaseApplication sakilaDatabaseApplication;

    @Mock
    private LanguageRepository languageRepository; //create fake version of language repository to run mock tests

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ActorRepository actorRepository;

    @Mock
    private CustomerRepository customerRepository;



    @BeforeEach // create an instance of our database without data
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(languageRepository,
                filmRepository, paymentRepository, categoryRepository, actorRepository, customerRepository);
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
    public void testAddFilm(){
        Film saveFilm = new Film("Batman: The Dark Knight", "Batman tries to kill the Joker", 2008, '3', 4.99, 10, 12.99,
                "PG");
        String expected = "save";
        String actual = sakilaDatabaseApplication.addFilm(saveFilm.getTitle(),saveFilm.getDescription(), saveFilm.getRelease_year(),
                saveFilm.getRental_duration(), saveFilm.getRental_rate(), saveFilm.getLength(), saveFilm.getReplacement_cost(),
                saveFilm.getRating());
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Film data has not been entered into the mock database");
    }
}
