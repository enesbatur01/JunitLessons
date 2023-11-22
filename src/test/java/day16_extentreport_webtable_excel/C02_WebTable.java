package day16_extentreport_webtable_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_WebTable extends TestBase {
    /*
    1- <table> bu tag tüm tabloyu kapsar, xpath kullanarak //table ifadesi ile tüm tabloları bulabilirsiniz.
    Birden fazla tablodan istediğiniz tabloyu seçmek için index belirtmemiz yeterlidir.

    2- <thead> bu tag eğer webtable da bir başlık bölümü varsa bu thead tag i içinde olur
        <thead> tagi içinde <tr> table row başlık satırını <th> tag ise başlık satırındaki her bir hücreyi temsil eder

    3- <tbody> bu tag webtable daki dataların yoğun olarak bulunduğu kısımdır <tr> satırları ve <td> bu satırlardaki her bir hücreyi temsil eder

     */
    @Test
    public void webTableTest() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        WebElement table1=driver.findElement(By.xpath("//table[1]"));
        System.out.println(table1.getText());

        //Task 2 : 3. Row'(satır) datalarını print edin
        System.out.println(driver.findElement(By.xpath("//table[1]//tr[3]")).getText());

        //Task 3 : Son row daki dataları print edin
        System.out.println(driver.findElement(By.xpath("//table[1]//tbody//tr[last()]")).getText());
        //Task 4 : 5. Column(sütun) datalarini print edin
        System.out.println(driver.findElement(By.xpath("//table[1]//tbody//tr[last()]//td[5]")).getText());

        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin
        printTable(2,3);


    }
    public void printTable(int row,int column){
        System.out.println(driver.findElement(By.xpath("//table[1]//tbody//tr["+row+"]//td["+column+"]")).getText());

    }
}
