package com.zirius.qa.utility;

import com.zirius.qa.pages.TestBase;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class XLReader extends TestBase {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;
    private XSSFCell xssfCell;
    private XSSFRow xssfRow;


    public XLReader(String excelPath, String sheetName) {
        try {
            fileInputStream = new FileInputStream(excelPath);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
        } catch (Exception exp) {
            exp.getMessage();
            exp.getStackTrace();
            exp.getCause();
        }
    }

    public int getRowCount() {
        int rowCount = xssfSheet.getPhysicalNumberOfRows();
        return rowCount;
    }

    public int getCellCount() {
        int cellCount = 0;
        cellCount = xssfSheet.getRow(0).getLastCellNum();
        return cellCount;
    }


    public Object getCellData(int rowNum, int cellNum) {

        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.getCell(cellNum);
        DataFormatter formatter = new DataFormatter();
        Object cellData = formatter.formatCellValue(xssfCell);
        return cellData;
    }

    public void setCellData(String excelPath, String sheetName, int rowNum, int cellNum, String data) throws Exception {

        fileInputStream = new FileInputStream(excelPath);

        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.getCell(cellNum);
        xssfCell.setCellValue(data);
        fileOutputStream = new FileOutputStream(excelPath);
        xssfWorkbook.write(fileOutputStream);
        xssfWorkbook.close();
        fileInputStream.close();
        fileOutputStream.close();
    }


}
