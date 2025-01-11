package com.farm.vegetablesales.service;

import com.farm.vegetablesales.entity.Sale;
import com.farm.vegetablesales.mapper.SaleMapper;
import com.farm.vegetablesales.mapper.VegetableMapper;
import com.farm.vegetablesales.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 販売サービス
 */
@Service
public class SaleService {

    private final SaleMapper saleMapper;
    private final VegetableMapper vegetableMapper;
    private final CustomerMapper customerMapper;

    public SaleService(SaleMapper saleMapper, 
                      VegetableMapper vegetableMapper,
                      CustomerMapper customerMapper) {
        this.saleMapper = saleMapper;
        this.vegetableMapper = vegetableMapper;
        this.customerMapper = customerMapper;
    }

    /**
     * 販売情報を登録する
     * 野菜IDと顧客IDの存在チェックを行う
     *
     * @param sale 販売情報
     * @return true: 成功、false: 失敗
     * @throws IllegalArgumentException 野菜または顧客が存在しない場合
     */
    @Transactional
    public boolean create(Sale sale) {
        validateForeignKeys(sale);
        return saleMapper.insert(sale) > 0;
    }

    /**
     * 販売情報を更新する
     * 野菜IDと顧客IDの存在チェックを行う
     *
     * @param sale 販売情報
     * @return true: 成功、false: 失敗
     * @throws IllegalArgumentException 野菜または顧客が存在しない場合
     */
    @Transactional
    public boolean update(Sale sale) {
        validateForeignKeys(sale);
        return saleMapper.update(sale) > 0;
    }

    /**
     * 販売情報を削除する
     *
     * @param id 販売ID
     * @return true: 成功、false: 失敗
     */
    @Transactional
    public boolean delete(Long id) {
        return saleMapper.deleteById(id) > 0;
    }

    /**
     * 販売情報を取得する
     *
     * @param id 販売ID
     * @return 販売情報
     */
    public Sale getById(Long id) {
        return saleMapper.selectById(id);
    }

    /**
     * すべての販売情報を取得する
     *
     * @return 販売情報リスト
     */
    public List<Sale> getAll() {
        return saleMapper.selectAll();
    }

    /**
     * 月別の販売情報を取得する
     *
     * @param year 年
     * @param month 月
     * @param customerId 顧客ID（オプション）
     * @return 販売情報リスト
     */
    public List<Sale> getMonthlyReport(int year, int month, Long customerId) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date startDate = cal.getTime();
        
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.MILLISECOND, -1);
        Date endDate = cal.getTime();

        if (customerId == null) {
            return saleMapper.selectByDateRange(startDate, endDate, null);
        } else {
            return saleMapper.selectByDateRange(startDate, endDate, customerId);
        }
    }

    /**
     * 外部キー制約のバリデーション
     *
     * @param sale 販売情報
     * @throws IllegalArgumentException 野菜または顧客が存在しない場合
     */
    private void validateForeignKeys(Sale sale) {
        if (vegetableMapper.selectById(sale.getVegetableId()) == null) {
            throw new IllegalArgumentException("指定された野菜が存在しません。");
        }
        if (customerMapper.selectById(sale.getCustomerId()) == null) {
            throw new IllegalArgumentException("指定された顧客が存在しません。");
        }
    }
}