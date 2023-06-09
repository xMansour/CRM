package com.mansour.crm.dao;

import com.mansour.crm.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

    List<Customer> searchForCustomer(String customerName);
}
