package com.mansour.crm.controllers;

import com.mansour.crm.dao.CustomerDAO;
import com.mansour.crm.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping( "/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customers = customerDAO.getCustomers();
        model.addAttribute("customers", customers);
        System.out.println("Customers: "+ customerDAO.getCustomers());
        return "list-customers";
    }


}
