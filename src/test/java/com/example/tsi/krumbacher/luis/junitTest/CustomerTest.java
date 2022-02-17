package com.example.tsi.krumbacher.luis.junitTest;

import com.example.tsi.krumbacher.luis.demo.Customer;
import com.example.tsi.krumbacher.luis.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("John", "Smith", "JohnSmith@gmail.com");

    @Test
    void getCustomer_id() {

    }

    @Test
    void getFirst_name() {
        assertEquals("Test failed","John",customer.getFirst_name());
    }

    @Test
    void setFirst_name() {
        customer.setFirst_name("Phillip");
        assertEquals("Test failed", "Phillip", customer.getFirst_name());
    }

    @Test
    void getLast_name() {
        assertEquals("Test failed","Smith",customer.getLast_name());
    }

    @Test
    void setLast_name() {
        customer.setLast_name("Jones");
        assertEquals("Test failed", "Jones", customer.getLast_name());
    }

    @Test
    void getEmail() {
        assertEquals("Test failed","JohnSmith@gmail.com", customer.getEmail());
    }

    @Test
    void setEmail() {
        customer.setEmail("phillipjones@gmail.com");
        assertEquals("Test failed", "phillipjones@gmail.com", customer.getEmail());
    }
}
