package com.practice.respository;

import com.practice.DataConfig;
import com.practice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DataConfig.class)
class CustomerRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){

        Customer customer = new Customer("Patrick", "Ojunde", "pojunde@mail.com");

        customerRepository.save(customer);

        System.out.println("Successful Save");


    }

}