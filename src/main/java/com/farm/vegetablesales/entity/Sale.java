package com.farm.vegetablesales.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 販売情報エンティティ
 */
public class Sale {
    /** 販売ID */
    private Long id;
    
    /** 野菜ID */
    private Long vegetableId;
    
    /** 顧客ID */
    private Long customerId;
    
    /** 数量 */
    private Integer quantity;
    
    /** 単価 */
    private BigDecimal price;
    
    /** 販売日 */
    private Date saleDate;
    
    /** 作成日時 */
    private Date createdAt;
    
    /** 更新日時 */
    private Date updatedAt;

    /** 野菜名（表示用） */
    private String vegetableName;
    
    /** 顧客名（表示用） */
    private String customerName;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}