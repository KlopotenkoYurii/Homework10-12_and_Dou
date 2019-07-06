package automation.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class  ExcelReader {
    private Workbook dataFile;

    private static final int FIRST_DATA_ROW = 1;
    private static final int COLUMN_NAME_ROW = 0;
    private static final int DEFAULT_SHEET_INDEX = 0;

    public ExcelReader(String pathToExcelFile) throws IOException {
        File file = new File(pathToExcelFile);
        FileInputStream inputStream = new FileInputStream(file);
        dataFile = new HSSFWorkbook(inputStream);
    }

    public String getValue(int row, int cell) {
        Sheet sheet = getDefaultSheet();
        return sheet.getRow(row).getCell(cell).getStringCellValue();
    }

    public String getValue(String name) {
        return getValue(FIRST_DATA_ROW, name);
    }

    public String getValue(int row, String name) {
        Sheet sheet = getDefaultSheet();

        return sheet.getRow(row).getCell(findCellIndex(name)).getStringCellValue();
    }

    public int getColumnSize() {
        return getDefaultSheet().getRow(COLUMN_NAME_ROW).getLastCellNum();
    }

    public int getRowsSize() {
        int row = getDefaultSheet().getPhysicalNumberOfRows();

        if (row <= 1) {
            return 0;
        }

        return row - 1;
    }

    private Sheet getDefaultSheet() {
        return dataFile.getSheetAt(DEFAULT_SHEET_INDEX);
    }


    private int findCellIndex(String name) {
        Sheet sheet = getDefaultSheet();
        Row row = sheet.getRow(COLUMN_NAME_ROW);

        Iterator<Cell> iterator = row.cellIterator();

        while (iterator.hasNext()) {
            Cell currentCell = iterator.next();
            String cellValue = currentCell.getStringCellValue();

            if (name.equals(cellValue)){
                return currentCell.getColumnIndex();
            }
        }

        throw new RuntimeException("Not Find Column with name: " + name);
    }


}
