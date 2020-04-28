package com.practice.service;

import com.practice.model.Customer;
import com.practice.respository.CustomerRepository;
import com.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
//@ComponentScan("com.practice")
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        customer = customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customer = customerRepository.save(customer);

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        Customer customerResponse = customerRepository.findById(id).get();
       return customerResponse;
    }

    @Override
    public Long countCustomers() {
        return customerRepository.count();
    }
}