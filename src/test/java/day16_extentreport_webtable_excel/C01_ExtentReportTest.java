package day16_extentreport_webtable_excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReportTest extends TestBase {
    @Test
    public void extentReusableFormatTest() {
        rapor("Chrome","AmazonTest");

        //Amazon SearchBox adında yeni bir test oluşturduk ve açıklama olarak üst başlık için testSteps yazdık
        extentTest=extentReports.createTest("Amazon Searchbox","Test Steps");


        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        extentTest.info("Kullanıcı Amazon anasayfasına gider");

        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");
        searchBox.submit();
        extentTest.info("Arama kutusuna selenium yazarak aratıldı");

        //Sayfa basliginin selenium icerdigini doğrulayalim
        String expectedTitle="selenium";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        extentTest.pass("Sayfa başlığının selenium içerdiği doğrulandı.");
        extentReports.flush();


    }
}
