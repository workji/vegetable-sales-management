package com.farm.vegetablesales.mapper;

import com.farm.vegetablesales.entity.Vegetable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 野菜マッパー
 */
@Mapper
public interface VegetableMapper {
    
    /**
     * 野菜を登録する
     *
     * @param vegetable 野菜情報
     * @return 登録件数
     */
    int insert(Vegetable vegetable);
    
    /**
     * 野菜を更新する
     *
     * @param vegetable 野菜情報
     * @return 更新件数
     */
    int update(Vegetable vegetable);
    
    /**
     * 野菜を削除する
     *
     * @param id 野菜ID
     * @return 削除件数
     */
    int deleteById(@Param("id") Long id);
    
    /**
     * 野菜を取得する
     *
     * @param id 野菜ID
     * @return 野菜情報
     */
    Vegetable selectById(@Param("id") Long id);
    
    /**
     * すべての野菜を取得する
     *
     * @return 野菜リスト
     */
    List<Vegetable> selectAll();
}