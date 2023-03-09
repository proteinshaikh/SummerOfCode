package Winter2022.h;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;


/*
 * Apache POI is a Java library for working with Microsoft Office documents such as Excel, Word, and PowerPoint
 * */
public class ApachePOI {

    static void excelOPS() throws IOException {
        FileInputStream input = new FileInputStream(new File("input.xlsx"));
        Workbook workbook = WorkbookFactory.create(input);

        Sheet inputSheet = workbook.getSheet("inputsheet");
        Sheet outputSheet = workbook.getSheet("outputsheet");

        String criteria = "ABC";

        int rowCounter = 0;
        int columnCounter = 0;

        //iterate through each row in the input sheet
        for (Row inputrow : inputSheet) {
            if (inputrow.getCell(0).getStringCellValue().equals(criteria)) {
                Row outputrow = outputSheet.createRow(rowCounter++);

                columnCounter = 0;

                for (Cell inputcell : inputrow) {

                    Cell outputcell = outputrow.createCell(columnCounter++);
                    outputcell.setCellValue(inputcell.getStringCellValue());
                }
            }
        }
        FileOutputStream output = new FileOutputStream("output.xlsx");
        workbook.write(output);

        output.close();
        input.close();
        workbook.close();

    }


}
