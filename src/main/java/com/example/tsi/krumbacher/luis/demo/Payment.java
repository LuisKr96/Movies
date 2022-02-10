package com.example.tsi.krumbacher.luis.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int payment_id;
    private int customer_id;
    private int staff_id;
    private int rental_id;
    private double amount;

    public Payment(int customer_id, int staff_id, int rental_id, double amount ){
        this.customer_id = customer_id;
        this.staff_id = staff_id;
        this.rental_id = rental_id;
        this.amount = amount;
    }
    public Payment(){}

    public int getPayment_id(){return payment_id;}


    public int getCustomer_id(){return customer_id;}

    public void setCustomer_id(int customer_id){
        this.customer_id = customer_id;
    }

    public int getStaff_id(){return staff_id;}

    public void setStaff_id(int staff_id){
        this.staff_id = staff_id;
    }

    public int getRental_id(){return rental_id;}

    public void setRental_id(int rental_id){
        this.rental_id = rental_id;
    }

    public double getAmount(){return amount;}

    public void setAmount(double amount){
        this.amount = amount;
    }


}
