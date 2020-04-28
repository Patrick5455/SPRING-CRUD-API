package com.practice.service;

import com.practice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public List<Customer> findAll();

    public void deleteById(Integer id);

    public Customer findById(int id);

    public Long countCustomers();










}
