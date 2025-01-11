package com.farm.vegetablesales.service;

import com.farm.vegetablesales.entity.Vegetable;
import com.farm.vegetablesales.mapper.VegetableMapper;
import com.farm.vegetablesales.mapper.SaleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 野菜サービス
 */
@Service
public class VegetableService {

    private final VegetableMapper vegetableMapper;
    private final SaleMapper saleMapper;

    public VegetableService(VegetableMapper vegetableMapper, SaleMapper saleMapper) {
        this.vegetableMapper = vegetableMapper;
        this.saleMapper = saleMapper;
    }

    /**
     * 野菜を登録する
     *
     * @param vegetable 野菜情報
     * @return true: 成功、false: 失敗
     */
    @Transactional
    public boolean create(Vegetable vegetable) {
        return vegetableMapper.insert(vegetable) > 0;
    }

    /**
     * 野菜を更新する
     *
     * @param vegetable 野菜情報
     * @return true: 成功、false: 失敗
     */
    @Transactional
    public boolean update(Vegetable vegetable) {
        return vegetableMapper.update(vegetable) > 0;
    }

    /**
     * 野菜を削除する
     * 関連する販売情報が存在する場合は削除できない
     *
     * @param id 野菜ID
     * @return true: 成功、false: 失敗
     * @throws IllegalStateException 関連する販売情報が存在する場合
     */
    @Transactional
    public boolean delete(Long id) {
        // 関連する販売情報の存在チェック
        if (saleMapper.existsByVegetableId(id)) {
            throw new IllegalStateException("この野菜に関連する販売情報が存在するため削除できません。");
        }
        return vegetableMapper.deleteById(id) > 0;
    }

    /**
     * 野菜を取得する
     *
     * @param id 野菜ID
     * @return 野菜情報
     */
    public Vegetable getById(Long id) {
        return vegetableMapper.selectById(id);
    }

    /**
     * すべての野菜を取得する
     *
     * @return 野菜リスト
     */
    public List<Vegetable> getAll() {
        return vegetableMapper.selectAll();
    }
}