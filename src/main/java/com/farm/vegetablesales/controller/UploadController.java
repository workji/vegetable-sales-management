package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.entity.Sale;
import com.farm.vegetablesales.service.CustomerService;
import com.farm.vegetablesales.service.SaleService;
import com.farm.vegetablesales.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/uploads")
public class UploadController {

    @Autowired
    private VegetableService vegetableService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SaleService saleService;

    @GetMapping("")
    public String uploads() {
        return "uploads/upload";
    }

    @PostMapping("/uploadVegetables")
    public String uploadVegetableData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            // ファイルが Excel 形式かを検証
            String fileName = file.getOriginalFilename();
            if (fileName == null || !(fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))) {
                throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
            }

            // MIME タイプの検証
            String contentType = file.getContentType();
            if (contentType == null ||
                    !(contentType.equals("application/vnd.ms-excel") ||
                            contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
                throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
            }

            vegetableService.saveVegetableData(file);
            redirectAttributes.addFlashAttribute("message", "Vegetable file uploaded successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload vegetable file: " + e.getMessage());
        }
        return "redirect:/uploads";
    }

    @PostMapping("/uploadCustomers")
    public String uploadCustomerData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            // ファイルが Excel 形式かを検証
            String fileName = file.getOriginalFilename();
            if (fileName == null || !(fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))) {
                throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
            }

            // MIME タイプの検証
            String contentType = file.getContentType();
            if (contentType == null ||
                    !(contentType.equals("application/vnd.ms-excel") ||
                            contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
                throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
            }

            customerService.saveCustomerData(file);
            redirectAttributes.addFlashAttribute("message", "Customer file uploaded successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload customer file: " + e.getMessage());
        }
        return "redirect:/uploads";
    }

    @PostMapping("/uploadSales")
    public String uploadSalesData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            // ファイルが Excel 形式かを検証
            String fileName = file.getOriginalFilename();
            if (fileName == null || !(fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))) {
                throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
            }

            // MIME タイプの検証
            String contentType = file.getContentType();
            if (contentType == null ||
                    !(contentType.equals("application/vnd.ms-excel") ||
                            contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
                throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
            }

            saleService.saveSalesData(file);
            redirectAttributes.addFlashAttribute("message", "Sales file uploaded successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload sales file: " + e.getMessage());
        }
        return "redirect:/uploads";
    }
}