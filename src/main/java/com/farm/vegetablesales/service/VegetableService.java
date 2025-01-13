package com.farm.vegetablesales.service;

import com.farm.vegetablesales.entity.Vegetable;
import com.farm.vegetablesales.mapper.VegetableMapper;
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
     * 野菜を取得する
     *
     * @param name 野菜名
     * @return 野菜情報
     */
    public Vegetable getByName(String name) {
        return vegetableMapper.selectByName(name);
    }

    /**
     * すべての野菜を取得する
     *
     * @return 野菜リスト
     */
    public List<Vegetable> getAll() {
        return vegetableMapper.selectAll();
    }

    /**
     * Excelファイルから野菜データを保存する
     *
     * @param file Excelファイル
     * @throws IOException 入出力例外
     */
    public void saveVegetableData(MultipartFile file) throws IOException {
        List<Vegetable> vegetables = parseExcelFile(file);
        for (Vegetable vegetable : vegetables) {
            create(vegetable);
        }
    }

    private List<Vegetable> parseExcelFile(MultipartFile file) throws IOException {
        List<Vegetable> vegetables = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Skip header row
            }
            Vegetable vegetable = new Vegetable();
            vegetable.setName(row.getCell(0).getStringCellValue());
            vegetables.add(vegetable);
        }
        workbook.close();
        return vegetables;
    }
}