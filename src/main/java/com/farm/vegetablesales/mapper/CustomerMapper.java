package com.farm.vegetablesales.mapper;

import com.farm.vegetablesales.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 顧客マッパー
 */
@Mapper
public interface CustomerMapper {
    
    /**
     * 顧客を登録する
     *
     * @param customer 顧客情報
     * @return 登録件数
     */
    int insert(Customer customer);
    
    /**
     * 顧客を更新する
     *
     * @param customer 顧客情報
     * @return 更新件数
     */
    int update(Customer customer);
    
    /**
     * 顧客を削除する
     *
     * @param id 顧客ID
     * @return 削除件数
     */
    int deleteById(@Param("id") Long id);
    
    /**
     * 顧客を取得する
     *
     * @param id 顧客ID
     * @return 顧客情報
     */
    Customer selectById(@Param("id") Long id);
    
    /**
     * すべての顧客を取得する
     *
     * @return 顧客リスト
     */
    List<Customer> selectAll();
}