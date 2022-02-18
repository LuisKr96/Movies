package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private Category category = new Category("New category");

    private Category newCat = new Category();

    @Test
    public void getCategoryId(){
        assertEquals(0, newCat.getCategory_id());
    }

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