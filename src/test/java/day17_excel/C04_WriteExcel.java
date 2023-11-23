package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,

        String path ="src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook=WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("customer_info");

        Row row = sheet.getRow(0);

        //üçüncü sütunu oluşturur çünkü index 0 dan başlar
        Cell cell3=row.createCell(2);

        cell3.setCellValue("STATUS");

        //ikinci satırın üçüncü hücresini oluştur ve değerini valid olarak ata
        sheet.getRow(1).createCell(2).setCellValue("valid");

        //dosyayı yazmak için bir output akışı oluşturur
        FileOutputStream fos = new FileOutputStream(path);

        //excel e yazar
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();





        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz
    }
}
