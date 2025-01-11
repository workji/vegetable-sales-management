package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.service.CustomerService;
import com.farm.vegetablesales.service.SaleService;
import com.farm.vegetablesales.entity.Sale;
import com.farm.vegetablesales.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private VegetableService vegetableService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String listSales(Model model) {
        List<Sale> sales = saleService.getAll();
        model.addAttribute("sales", sales);
        return "sales/list";
    }

    @GetMapping("/monthly")
    public String monthlySalesReport(@RequestParam(value = "year", required = false) Integer year,
                                     @RequestParam(value = "month", required = false) Integer month,
                                     @RequestParam(value = "customer", required = false) Long customerId,
                                     Model model) {
        LocalDate now = LocalDate.now();
        if (year == null || month == null) {
            year = now.getYear();
            month = now.getMonthValue();
        }
        List<Sale> monthlySales = saleService.getMonthlyReport(year, month, customerId);
        model.addAttribute("monthlySales", monthlySales);
        model.addAttribute("currentYear", now.getYear());
        model.addAttribute("currentMonth", now.getMonthValue());
        model.addAttribute("searchYear", year);
        model.addAttribute("searchMonth", month);
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("searchCustomerId", customerId);
        return "sales/monthly";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sale", new Sale());
        model.addAttribute("vegetables", vegetableService.getAll());
        model.addAttribute("customers", customerService.getAll());
        return "sales/add";
    }

    @PostMapping("/add")
    public String addSale(@ModelAttribute Sale sale) {
        saleService.create(sale);
        return "redirect:/sales";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Sale sale = saleService.getById(id);
        model.addAttribute("sale", sale);
        model.addAttribute("vegetables", vegetableService.getAll());
        model.addAttribute("customers", customerService.getAll());
        return "sales/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateSale(@PathVariable("id") long id, @ModelAttribute Sale sale) {
        saleService.update(sale);
        return "redirect:/sales";
    }

    @GetMapping("/details/{id}")
    public String viewDetails(@PathVariable("id") long id, Model model) {
        Sale sale = saleService.getById(id);
        model.addAttribute("sale", sale);
        return "sales/details";
    }

    @GetMapping("/delete/{id}")
    public String deleteSale(@PathVariable("id") long id) {
        saleService.delete(id);
        return "redirect:/sales";
    }
}