package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

//    public static void main(String[] args) throws EncryptedDocumentException, IOException {
//        // Create an instance of the ReadXLSdata class
//        ReadXLSdata read = new ReadXLSdata();
//        // Call the getData method with "login" as the sheet name
//        read.getData("login");
//    }

    @DataProvider(name="testdata")
    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
    	
    	String excelSheetName = m.getName();
        // Specify the path to the Excel file using the current directory
        File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
        
        // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(f);
        
        // Create a Workbook instance from the FileInputStream (supports both .xls and .xlsx files)
        Workbook wb = WorkbookFactory.create(fis);
        
        // Get the sheet by its name from the workbook
        Sheet sheetName = wb.getSheet(excelSheetName);
        
        // Get the total number of rows in the sheet (excluding the header row)
        int totalRows = sheetName.getLastRowNum();
        System.out.println("Total Rows: " + totalRows);
        
        // Get the first row (header row) to determine the number of columns
        Row rowCells = sheetName.getRow(0);
        
        // Get the total number of columns in the sheet
        int totalCols = rowCells.getLastCellNum();
        System.out.println("Total Columns: " + totalCols);
        
        // Create a DataFormatter to format the cell values into strings
        DataFormatter format = new DataFormatter();
        
        // Initialize a 2D array to store the data from the Excel sheet
        String[][] testData = new String[totalRows][totalCols];
        
        // Loop through each row and column to extract data
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                // Read and format the cell value and store it in the array
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                
                // Print the extracted data to the console for verification
//                System.out.println("Data[" + (i-1) + "][" + j + "]: " + testData[i - 1][j]);
                System.out.println(testData[i-1][j]);
            }
        }
        
        // Close the workbook to free up resources
        wb.close();
        
        // Return the 2D array containing the extracted data
        return testData;
    }
}
