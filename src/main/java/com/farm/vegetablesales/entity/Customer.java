package com.farm.vegetablesales.entity;

import java.util.Date;

/**
 * 顧客（スーパー）エンティティ
 */
public class Customer {
    /** 顧客ID */
    private Long id;
    
    /** 顧客名 */
    private String name;
    
    /** 住所 */
    private String address;
    
    /** 電話番号 */
    private String phone;
    
    /** 作成日時 */
    private Date createdAt;
    
    /** 更新日時 */
    private Date updatedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}