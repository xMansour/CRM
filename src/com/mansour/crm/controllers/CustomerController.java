package com.mansour.crm.controllers;

import com.mansour.crm.entities.Customer;
import com.mansour.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }


    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }


    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }


    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }


    @GetMapping("searchForCustomer")
    public String searchForCustomer(@RequestParam("customerName") String customerName, Model model){
        List<Customer> customers = customerService.searchForCustomer(customerName);
        model.addAttribute("customers", customers);
        return "list-customers";

    }


}
