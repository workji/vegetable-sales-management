package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.service.CustomerService;
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
}