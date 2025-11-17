package com.shashankkumar.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        String value = "";
        if (cell.getCellType() == CellType.STRING) value = cell.getStringCellValue();
        else if (cell.getCellType() == CellType.NUMERIC) value = String.valueOf((int)cell.getNumericCellValue());

        workbook.close();
        fis.close();
        return value;
    }
}
