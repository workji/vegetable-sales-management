package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.service.VegetableService;
import com.farm.vegetablesales.entity.Vegetable;
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

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("vegetable", new Vegetable());
        return "vegetables/add";
    }

    @PostMapping("/add")
    public String addVegetable(@ModelAttribute Vegetable vegetable) {
        vegetableService.create(vegetable);
        return "redirect:/vegetables";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Vegetable vegetable = vegetableService.getById(id);
        model.addAttribute("vegetable", vegetable);
        return "vegetables/edit";
    }

    @PostMapping("/update/{id}")
    public String updateVegetable(@PathVariable("id") long id, @ModelAttribute Vegetable vegetable) {
        vegetableService.update(vegetable);
        return "redirect:/vegetables";
    }

    @GetMapping("/details/{id}")
    public String viewDetails(@PathVariable("id") long id, Model model) {
        Vegetable vegetable = vegetableService.getById(id);
        model.addAttribute("vegetable", vegetable);
        return "vegetables/details";
    }

    @GetMapping("/delete/{id}")
    public String deleteVegetable(@PathVariable("id") long id) {
        vegetableService.delete(id);
        return "redirect:/vegetables";
    }
}