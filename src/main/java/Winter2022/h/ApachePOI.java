package Winter2022.h;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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

    }


}
