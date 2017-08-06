import com.lorraine.echelon.utils.ExcelInit;
import com.lorraine.echelon.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class GetRowTest {

    @Test
    public void getRow() throws IOException {
        String path = this.getClass().getResource("/").getPath().toString().split("target")[0].toString();
        path = path + "resources/test.xlsx";
        System.out.println(path);
        Workbook workbook = new XSSFWorkbook(path);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        System.out.println(row.getCell(0));
    }
}
