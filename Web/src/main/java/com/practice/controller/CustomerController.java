package com.practice.controller;

import com.practice.model.Customer;
import com.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private Customer customerResponse;

    @GetMapping("/")
    public String showHome(){
        return "This is the home page";
    }

    @PostMapping("/newCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable Integer id,@RequestBody Customer customer)
           {
              Customer existingCustomer = customerService.findById(id);
              if(existingCustomer == null) {
                  System.err.println("customer does not exist");
                  throw new RuntimeException("customer does not exist");
              }
              customerResponse = customerService.updateCustomer(customer);
              System.out.println(customerResponse.toString());
              return customerResponse;
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> findAll(){
        List<Customer> result= customerService.findAll();
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id)
    {
        try{
            Customer existingCustomer = customerService.findById(id);
            if(existingCustomer != null)
                customerService.deleteById(id);
    }
        catch (RuntimeException e){
        e.printStackTrace();}
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return customerService.findById(id);
    }

    @GetMapping("/customerCount")
    public Long customerCount(){
        return customerService.countCustomers();
    }













}
