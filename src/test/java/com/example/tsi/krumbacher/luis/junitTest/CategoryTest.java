package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private Category category = new Category("New category");

    @Test
    public void getName() {
        assertEquals("New category",category.getName(), "test failed");
    }

    @Test
    public void setName() {
        category.setName("Anime for 18+");
        assertEquals("Anime for 18+",category.getName(), "test failed");
    }
}