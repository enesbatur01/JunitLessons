package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        //1-Projemizde bulunan excel dosyasinin path ini almaliyiz
        String path ="src/test/java/resources/Capitals.xlsx";

        //2- FileInputStream classından bir obje oluşturarak çalışmak istediğimiz excel dosyasındaki dataları akuşa sunduk
        //bu akışı kullanarak excel dosyasından gelen dataları java programımıza aktarmış olacağız
        FileInputStream fis =new FileInputStream(path);

        //3- fis objesi üzerinden bir excel(=workbook) workbook objecti oluşturduk
        Workbook workbook=WorkbookFactory.create(fis);

        //4- bir excel dosyasında birden fazla sayfa bulunabilir, Sheet1 adlı sayfayı açtık  ve bunu Sheet objesine attık
        Sheet sheet=workbook.getSheet("Sheet1");

        //5- Bir excel sayfasında birden fazla satır bulunabilir, ilk satırı seçtirip Row(satır) sepetine koyduk
        Row row = sheet.getRow(0);//excel de satırlar her zaman indexleri 0 dan başlar

        //6- Bir excel satırında birden fazla cell(hücre) olabilir, ilk celli seçip Cell kutusuna koyduk;
        Cell cell = row.getCell(0);//excel de hücreler her zaman indexleri 0 dan başlar
        System.out.println(cell);


    }
    @Test
    public void test02() throws IOException {
        String path ="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook=WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

    }
}

