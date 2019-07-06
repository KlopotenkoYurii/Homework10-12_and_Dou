package automation.data;

import com.skillup.automation.utils.ExcelReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Paths;

public class ReadFromExcelProvider {

    @DataProvider(name = "dataLoginFromExcel")
    public Object[][] getData() throws IOException {
        String path = Paths.get(System.getProperty("user.dir"), "positiveLoginData.xls").toAbsolutePath().toString();

        ExcelReader excel = new ExcelReader(path);
        int columnSize = excel.getColumnSize();
        int rowSize = excel.getRowsSize();

        Object[][] data = new Object[rowSize][columnSize];

        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                data[rowIndex][columnIndex] = excel.getValue(rowIndex + 1, columnIndex);
            }
        }

        return data;
    }
}
