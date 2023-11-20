package day13_seleniumwaits_exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_NoSuchElementException extends TestBase {
      /*
    Sayfadaki bir webelementi locate ettigmiz halde NoSuchElementException aliyorsak;

    1- Locate i tekrar kontrol ederiz buna ragmen ayni hatayi almaya devam ediyorsak
    2- Wait /Syncronization problemi olabilir, ve cozum icin implictly wait de yeterli sure olduguna emin olmaliyiz, ihtiyaca gore bu süreyi artirabiliriz
    3- Webelementin iframe icinde olup olmadigina bakariz, (alert..) yine ayni hatayi aliyorsak
    4- Driver webelementi goremiyordur, dolayisiyla actions classi kullanarak scroll yaparak yada baska yöntemlerle webelementin gorunur olmasini saglariz

     */

    @Test
    public void test01() {
        driver.get("https://amazon.com");
        WebElement searchBox=driver.findElement(By.id("YANLIS LOCATE"));
        searchBox.sendKeys("laptop");
        searchBox.submit();
    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");
        WebElement searchBox=driver.findElement(By.cssSelector("//*[YANLIS LOCATE"));
        //bu ornekte Xpath syntaxi kullanmamiza ragmen cssSelector locator unu  kullandigimz icin InvalidSelector hatasi aldik
        searchBox.sendKeys("laptop");
        searchBox.submit();
    }
}
