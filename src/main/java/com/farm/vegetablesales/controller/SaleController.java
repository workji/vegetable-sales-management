package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales")
public class SaleController {
    
    @Autowired
    private SaleService saleService;

    @GetMapping("")
    public String listSales(Model model) {
        model.addAttribute("sales", saleService.getAll());
        return "sales/list";
    }

    @GetMapping("/monthly")
    public String monthlySalesReport(Model model) {
        model.addAttribute("monthlySales", saleService.getMonthlyReport(2020, 1, 1l));
        return "sales/monthly";
    }
}