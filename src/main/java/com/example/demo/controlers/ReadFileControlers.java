package com.example.demo.controlers;

import com.example.demo.ReadfileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.*;
import java.util.*;

@RestController
public class ReadFileControlers {

    @GetMapping("/read-excel-file")
    public Map<Integer, List<String>> ReadExcel()
    {
        String fileLocation="Q:\\Interndemo\\src\\main\\java\\com\\example\\demo\\controlers\\Demo.xlsx";
        try {
            //open file
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(file);
            // crate a file

            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:  data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
                       // case NUMERIC: data.get(new Integer(i));
                            // default: data.get(new Integer(i)).add(" ");
                    }
                }
                i++;
            }
            return data;
        }
        catch (FileNotFoundException e)
        {
            throw new ReadfileException(HttpStatus.NOT_FOUND);
        }
        catch (IOException e)
        {
            throw new ReadfileException(HttpStatus.FORBIDDEN);
        }
        catch (Exception e)
        {
            throw new ReadfileException(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/write-file")
    public String WriteInFile()
    {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Qasim", "Riaz"});
        data.put("3", new Object[] {2, "Ahmad", "Afzal"});
        data.put("4", new Object[] {3, "Mustafa", "ALi"});
        data.put("5", new Object[] {4, "saad", "Nadeem"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("Q:\\Interndemo\\src\\main\\java\\com\\example\\demo\\controlers\\Student.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("written successfully on file.");
        }
        catch (FileNotFoundException e)
        {
            throw new ReadfileException(HttpStatus.NOT_FOUND);
        }
        catch (IOException e)
        {
            throw new ReadfileException(HttpStatus.FORBIDDEN);
        }
        catch (Exception e)
        {
            throw new ReadfileException(HttpStatus.BAD_REQUEST);
        }
        return "Success";
    }

}
