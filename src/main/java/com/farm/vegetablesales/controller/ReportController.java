package com.farm.vegetablesales.controller;

import com.farm.vegetablesales.entity.Sale;
import com.farm.vegetablesales.service.CustomerService;
import com.farm.vegetablesales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private CustomerService customerService;

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
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("searchYear", year);
        model.addAttribute("searchMonth", month);
        model.addAttribute("searchCustomerId", customerId != null?customerId : -1L);
        return "reports/monthly";
    }

    @GetMapping("/monthly/csv")
    public ResponseEntity<byte[]> downloadMonthlyReportCsv(@RequestParam(value = "year", required = false) Integer year,
                                                           @RequestParam(value = "month", required = false) Integer month,
                                                           @RequestParam(value = "customer", required = false) Long customerId) throws IOException {
        LocalDate now = LocalDate.now();
        if (year == null || month == null) {
            year = now.getYear();
            month = now.getMonthValue();
        }
        List<Sale> sales = saleService.getMonthlyReport(year, month, customerId);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(0xEF);
        out.write(0xBB);
        out.write(0xBF);
        OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        writer.write("ID,Date,Price,Customer Name\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Sale sale : sales) {
            writer.write(String.format("%d,%s,%s,%s\n", sale.getId(), sale.getSaleDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter), sale.getPrice(), sale.getCustomerName()));
        }
        writer.flush();
        writer.close();

        byte[] csvBytes = out.toByteArray();
        String fileName = String.format("report_monthly_%d%02d_%s.csv", year, month, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok()
                .headers(headers)
                .body(csvBytes);
    }
}
