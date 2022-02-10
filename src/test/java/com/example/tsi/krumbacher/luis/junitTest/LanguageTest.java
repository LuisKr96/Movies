package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Language;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LanguageTest {

    private Language language = new Language();

    @Test
    public void test_getName(){
        language.setName("test");
        assertEquals("test failed", language.getName(), "test");
    }


}
