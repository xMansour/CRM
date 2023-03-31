package com.mansour.crm.services;

import com.mansour.crm.dao.CustomerDAO;
import com.mansour.crm.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDAO customerDAO;


    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }
    @Transactional
    @Override
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    @Transactional
    @Override
    public List<Customer> searchForCustomer(String customerName) {
        return customerDAO.searchForCustomer(customerName);
    }
}
