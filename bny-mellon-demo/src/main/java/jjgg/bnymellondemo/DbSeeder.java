package jjgg.bnymellondemo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import jjgg.bnymellondemo.ComplaintRepository;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner  {
    //public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\Tarvos\\Desktop\\testComplaints.xlsx";
    private ComplaintRepository complaintRepository;

    public DbSeeder(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public void run(String... strings) throws IOException, InvalidFormatException {

        /*//this.complaintRepository.deleteAll();
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // obtain a rowIterator and columnIterator and iterate over them
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            String results = null;

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                results= results +"/"+cellValue;
            }
            String [] stuff = results.split("/");

            Complaint complaint = new Complaint(
                    stuff[1],
                    stuff[2],
                    Integer.parseInt(stuff[3]),
                    stuff[4],
                    Integer.parseInt(stuff[5])
            );
            this.complaintRepository.save(complaint);
        }*/
    }
}
