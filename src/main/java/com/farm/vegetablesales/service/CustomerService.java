package com.farm.vegetablesales.service;

import com.farm.vegetablesales.entity.Customer;
import com.farm.vegetablesales.mapper.CustomerMapper;
import com.farm.vegetablesales.mapper.SaleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * すべての顧客を取得する
     *
     * @return 顧客リスト
     */
    public List<Customer> getAll() {
        return customerMapper.selectAll();
    }
}