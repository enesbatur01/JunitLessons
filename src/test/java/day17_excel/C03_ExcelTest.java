package day17_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ExcelTest extends TestBase {
    @Test
    public void excelTest() throws IOException {

        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");
        //Login butonuna basalım
        WebElement loginButton=driver.findElement(By.xpath("(//a[@role='button'])[1]"));
        loginButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        WebElement mailBox = driver.findElement(By.xpath("//input [@name='email']"));
        WebElement passBox = driver.findElement(By.xpath("//input [@name='password']"));

        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        String path = "src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        String mail=workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password=workbook.getSheet("customer_info").getRow(1).getCell(1).toString();
        mailBox.sendKeys(mail);
        passBox.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Login olduğumuzu doğrulayalım
        driver.findElement(By.xpath("//button[@id='dropdown-basic-button']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Logout']")).isDisplayed());


    }
}
