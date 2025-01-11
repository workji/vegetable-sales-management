package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vegetables")
public class VegetableController {
    
    @Autowired
    private VegetableService vegetableService;

    @GetMapping("")
    public String listVegetables(Model model) {
        model.addAttribute("vegetables", vegetableService.getAll());
        return "vegetables/list";
    }
}