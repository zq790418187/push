package DOME;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class dataProvideExcel {

@DataProvider
public Object[][] getData(){
    String Path=this.getClass().getResource("test.xlsx").getPath();
    return getDataFromExcel(Path);
}

@Test(dataProvider="getData")
public void testDataprovide(String name,String password) {
    System.out.println(name);
    System.out.println(password);
}

    public Object[][] getDataFromExcel(String Path) {
        Workbook workbook;
        try {
            FileInputStream excelInputStream = new FileInputStream(Path);
            workbook = new XSSFWorkbook(excelInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowInExcel = sheet.getPhysicalNumberOfRows();
            int columnInExcel = sheet.getRow(0).getPhysicalNumberOfCells();
            String[][] obj = new String[rowInExcel-1][columnInExcel];
            for(int row = 1; row < rowInExcel; row++){
                for(int col = 0; col < columnInExcel; col++){
                    sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
                    obj[row - 1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
                    System.out.println(obj[row - 1][col]);
                }
            }
            return obj;
        }catch(Exception e){
            throw new SkipException(e.getMessage());
        }

    }

    }

