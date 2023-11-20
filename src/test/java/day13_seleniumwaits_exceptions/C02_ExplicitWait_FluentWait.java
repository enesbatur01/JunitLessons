package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_FluentWait extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//*[.='Hello World!']"));


        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        wait.withTimeout(Duration.ofSeconds(20)).//maximum bekleme süresi
                pollingEvery(Duration.ofMillis(200)).//her 200 milisaniyede bir kosulu kontrol et
                withMessage("WebElementi ve Sureyi Kontrol Et").//Eger belirtilen maximum süre icinde kosul saglanmaz ise buradaki hata mesaji
                              //console da TimeOutException ile birlikte gorunecek
                until(ExpectedConditions.visibilityOf(helloWorld));//webelementinin gorunur olup olmadigini kontrol eder

        Assert.assertEquals("Hello World!",helloWorld.getText());


    }

}
