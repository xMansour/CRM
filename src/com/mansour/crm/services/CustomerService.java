package com.mansour.crm.services;

import com.mansour.crm.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();


    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

    List<Customer> searchForCustomer(String customerName);
}
