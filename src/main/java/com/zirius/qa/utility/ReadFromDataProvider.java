package com.zirius.qa.utility;

import com.zirius.qa.pages.TestBase;
import org.testng.annotations.DataProvider;

import java.io.File;

public class ReadFromDataProvider extends TestBase {
    XLReader xlReader;
    String excelPath = "." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "zirius" + File.separator + "qa" + File.separator + "testdata" + File.separator + "ContactUsFormTestData.xlsx";


    @DataProvider(name = "ContactUsFormField")
    public Object[][] ContactUsFormField() throws Exception {

        File file = new File(".//testdata//ContactUsFormTestData.xlsx");
        System.out.println(file.getAbsolutePath() + " \n" + file.getCanonicalPath() + " \n" + file.getPath());
        xlReader = new XLReader(excelPath, "ContactUs");

        int rowCount = xlReader.getRowCount();
        int colCount = xlReader.getCellCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            colCount = xlReader.getCellCount();
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = xlReader.getCellData(i, j);
            }
        }
        System.out.println("Row Count: " + rowCount + " Column Count: " + colCount);
        return data;
    }
}


