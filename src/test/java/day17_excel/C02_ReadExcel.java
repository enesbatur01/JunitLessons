package day17_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        String path ="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook woorkbook=WorkbookFactory.create(fis);
        System.out.println(woorkbook.getSheet("Sheet1").getRow(0).getCell(1));

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String expectedCell="France";
        String actualCell=woorkbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        Assert.assertEquals(expectedCell,actualCell);

        //Örnek 3: Kullanılan satır sayısın bulun
        //.getPhysicalNumberOfRows() bu method içi dolu olan satırların yani rowların sayısını verir kullanılanları verir
        //ve sayı verdiği için 1 den başlar
        int activeRowCount = woorkbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println(activeRowCount);

        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        //.getLastRowNum() bu method Index verir ,sayfadaki son row yani satırın INDEX ini verir
        //eger bir excel sayfasında toplam 5 satır varsa bu method 4 verecektir çünkü index 0 dan başlar
        System.out.println(woorkbook.getSheet("Sheet1").getLastRowNum());

        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}
        String country=woorkbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        String capital=woorkbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(country + " "+ capital);

        Map<String,String> countryMap = new HashMap<>();

        int idx = woorkbook.getSheet("Sheet1").getLastRowNum();
        for (int i = 1; i <= idx; i++) {
            String country1=woorkbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital1=woorkbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            countryMap.put(country1,capital1);
        }
        System.out.println(countryMap);



    }
}
