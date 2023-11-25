package day19_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorStyle extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //aramakutusunun style özelliklerini degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //searchBox webelementinin etrafına 5 pixel kalınlığında kırmızı bir çerçeve ekledik
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red'",searchBox);

        //elementin arka plan rengini değiştirmek
        js.executeScript("arguments[0].style.backgroundColor='green'",searchBox);

        //searchBox webelementinin metin rengini beyaza çevirdik
        js.executeScript("arguments[0].style.color='white'",searchBox);


        //sayfanin ekran görüntüsünü alalim
        screensShot();



    }
}
