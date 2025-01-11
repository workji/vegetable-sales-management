package com.farm.vegetablesales.mapper;

import com.farm.vegetablesales.entity.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

/**
 * 販売マッパー
 */
@Mapper
public interface SaleMapper {
    
    /**
     * 販売情報を登録する
     *
     * @param sale 販売情報
     * @return 登録件数
     */
    int insert(Sale sale);
    
    /**
     * 販売情報を更新する
     *
     * @param sale 販売情報
     * @return 更新件数
     */
    int update(Sale sale);
    
    /**
     * 販売情報を削除する
     *
     * @param id 販売ID
     * @return 削除件数
     */
    int deleteById(@Param("id") Long id);
    
    /**
     * 販売情報を取得する
     *
     * @param id 販売ID
     * @return 販売情報
     */
    Sale selectById(@Param("id") Long id);
    
    /**
     * すべての販売情報を取得する
     *
     * @return 販売情報リスト
     */
    List<Sale> selectAll();
    
    /**
     * 月別の販売情報を取得する
     *
     * @param startDate 開始日
     * @param endDate 終了日
     * @param customerId 顧客ID（オプション）
     * @return 販売情報リスト
     */
    List<Sale> selectByDateRange(@Param("startDate") Date startDate, 
                                @Param("endDate") Date endDate,
                                @Param("customerId") Long customerId);
    
    /**
     * 野菜IDに関連する販売情報の存在チェック
     *
     * @param vegetableId 野菜ID
     * @return 存在する場合true
     */
    boolean existsByVegetableId(@Param("vegetableId") Long vegetableId);
    
    /**
     * 顧客IDに関連する販売情報の存在チェック
     *
     * @param customerId 顧客ID
     * @return 存在する場合true
     */
    boolean existsByCustomerId(@Param("customerId") Long customerId);
}