package com.farm.vegetablesales.service;

import com.farm.vegetablesales.entity.Customer;
import com.farm.vegetablesales.entity.Sale;
import com.farm.vegetablesales.mapper.CustomerMapper;
import com.farm.vegetablesales.mapper.SaleMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 顧客サービス
 */
@Service
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final SaleMapper saleMapper;

    public CustomerService(CustomerMapper customerMapper, SaleMapper saleMapper) {
        this.customerMapper = customerMapper;
        this.saleMapper = saleMapper;
    }

    /**
     * 顧客を登録する
     *
     * @param customer 顧客情報
     * @return true: 成功、false: 失敗
     */
    @Transactional
    public boolean create(Customer customer) {
        return customerMapper.insert(customer) > 0;
    }

    /**
     * 顧客を更新する
     *
     * @param customer 顧客情報
     * @return true: 成功、false: 失敗
     */
    @Transactional
    public boolean update(Customer customer) {
        return customerMapper.update(customer) > 0;
    }

    /**
     * 顧客を削除する
     * 関連する販売情報が存在する場合は削除できない
     *
     * @param id 顧客ID
     * @return true: 成功、false: 失敗
     * @throws IllegalStateException 関連する販売情報が存在する場合
     */
    @Transactional
    public boolean delete(Long id) {
        // 関連する販売情報の存在チェック
        if (saleMapper.existsByCustomerId(id)) {
            throw new IllegalStateException("この顧客に関連する販売情報が存在するため削除できません。");
        }
        return customerMapper.deleteById(id) > 0;
    }

    /**
     * 顧客を取得する
     *
     * @param id 顧客ID
     * @return 顧客情報
     */
    public Customer getById(Long id) {
        return customerMapper.selectById(id);
    }

    /**
     * 顧客を取得する
     *
     * @param name 顧客名
     * @return 顧客情報
     */
    public Customer getByName(String name) {
        return customerMapper.selectByName(name);
    }

    /**
     * すべての顧客を取得する
     *
     * @return 顧客リスト
     */
    public List<Customer> getAll() {
        return customerMapper.selectAll();
    }

    /**
     * Excelファイルから野菜データを保存する
     *
     * @param file Excelファイル
     * @throws IOException 入出力例外
     */
    public void saveCustomerData(MultipartFile file) throws IOException {
        List<Customer> customers = parseExcelFile(file);
        for (Customer customer : customers) {
            create(customer);
        }
    }

    private List<Customer> parseExcelFile(MultipartFile file) throws IOException {
        List<Customer> customers = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Skip header row
            }
            Customer customer = new Customer();
            customer.setName(row.getCell(0).getStringCellValue());
            customer.setAddress(row.getCell(1).getStringCellValue());
            customer.setPhone(row.getCell(2).getStringCellValue());
            customers.add(customer);
        }
        workbook.close();
        return customers;
    }
}