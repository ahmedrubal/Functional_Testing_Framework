package io.com_functional_testing.utils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static io.com_functional_testing.utils.Logs.logInfo;

public class ReadData {

    // Reading excel data using Array concept

    public static Object[][] getExcelData(String excelFilePath, String sheetName) {
        String[][] excelData = null;
        FileInputStream fileInputStream = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        try {//FileInput Stream to read excel file
            fileInputStream = new FileInputStream(excelFilePath);
            //workbook to store  file data
            workbook = new XSSFWorkbook(fileInputStream);
            //workbook to access sheet
            sheet = workbook.getSheet(sheetName);
            logInfo("Excel file is opened");
            // get sheet row count
            int sheetRowCount = sheet.getLastRowNum();
            System.out.println(sheetRowCount);
            //get row cell count
            int sheetCellCount = sheet.getRow(0).getLastCellNum();
            System.out.println(sheetCellCount);
            excelData = new String[sheetRowCount][sheetCellCount];
            //looping through row and cell
            for (int r = 1; r <= sheetRowCount; r++) {
               // System.out.println(r);
                for (int c = 0; c < sheetCellCount; c++) {
                   // System.out.println(c);
                    //excelData storing each cell value
                    excelData[r-1][c] = getCellData(sheet.getRow(r).getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));


                }
               // System.out.println("row is completed");
                break;
            }
        } catch (FileNotFoundException e) {
            logInfo("Can not find Excel file");
            e.printStackTrace();
        } catch (Exception e) {
            logInfo("Can't read or write file");
            e.printStackTrace();
        }
        logInfo("returning excle data");
        return excelData;

    }

    public static String getCellData(XSSFCell cell) {
        String cellData = null;
        try {
            cellData = switch (cell.getCellType()) {
                case NUMERIC -> String.valueOf(cell.getNumericCellValue()).trim();
                case STRING -> cell.getStringCellValue().trim();
                case BLANK -> "";
                case BOOLEAN -> String.valueOf(cell.getBooleanCellValue()).trim();
                default -> cell.getStringCellValue().trim();
            };
        } catch (Exception e) {
            logInfo("cell data is not available");
            e.printStackTrace();
        }
        return cellData;
    }
}









