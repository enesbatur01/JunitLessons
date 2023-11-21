package day15_screenshot_extentreport;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Ana sayfanın başarıyla yüklendiğini doğrula.
        String expectedUrl = "https://techproeducation.com/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
        //Sayfanın ekran görüntüsünü alin
        screensShot();
        //Sayfada görüntülenen telefon numarasinin +1 585 304 29 59 oldugunu dogrulayin
        WebElement numElement=driver.findElement(By.xpath("//a[.='+1 585 304 29 59']"));
        String expectedNum= "+1 585 304 29 59";
        Assert.assertEquals(expectedNum,numElement.getText());
        getScreenshotOfWebelement(numElement);
        //Techpro ana sayfasi en altta logonun görüntülendigini dogrulayin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();

        WebElement logo=driver.findElement(By.xpath("//img[@class='footerLogo']"));
        logo.isDisplayed();

        //logonun ekran goruntusunu alalım
        getScreenshotOfWebelement(logo);

    }
    @Test
    public void test(){
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Ve sayfanın resmini alalım
        screensShot();
        //Arama kutusuna metin göndererek ekran goruntusun alalim
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("salatalık");
        searchbox.submit();
        searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        getScreenshotOfWebelement(searchbox);

    }
}
