package io.com_functional_testing.utils;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// this class just to show another approach to read data using array list concept
// I have been used Read data class for my framework that is array concept
public class ReadExcelFile {
    // Method to read Excel file
    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
        // Load the Excel file
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // Count the rows and columns
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        List<Object[]> data = new ArrayList<>();

        // Iterate through the rows and columns
        for (int i = 1; i < rows; i++) {  // int i =1 used to Skip header row
            Row row = sheet.getRow(i);
            Object[] rowData = new Object[cols];

            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                rowData[j] = getCellValue(cell); // Fetch cell value
            }
            data.add(rowData);
        }

        // Convert List to 2D array and return
        Object[][] dataArray = new Object[data.size()][cols];
        return data.toArray(dataArray);
    }

    // Helper method to extract cell value
    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }
}
