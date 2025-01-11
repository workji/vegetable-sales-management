package com.farm.vegetablesales.entity;

import java.util.Date;

/**
 * 野菜エンティティ
 */
public class Vegetable {
    /** 野菜ID */
    private Long id;
    
    /** 野菜名 */
    private String name;
    
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