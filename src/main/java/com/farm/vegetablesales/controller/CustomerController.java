package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.service.CustomerService;
import com.farm.vegetablesales.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAll());
        return "customers/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/add";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.create(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customers/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") long id, @ModelAttribute Customer customer) {
        customerService.update(customer);
        return "redirect:/customers";
    }

    @GetMapping("/details/{id}")
    public String viewDetails(@PathVariable("id") long id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customers/details";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}