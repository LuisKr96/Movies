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


@ExtendWith(MockitoExtension.class) //inherit characteristcs to use Mockito
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

    @BeforeEach // create an instance of our database without data
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(languageRepository,
                filmRepository, paymentRepository, categoryRepository);
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


}
