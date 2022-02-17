package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Language;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LanguageTest {

    private Language language = new Language("German");

    @Test
    public void test_getName(){
        assertEquals("test failed", language.getName(), "German");
    }

    @Test
    public void test_setName() {
        language.setName("Portugese");
        assertEquals("test failed", language.getName(), "Portugese");

    }


}
