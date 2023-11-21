package day14_exception_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_StaleElementReferenceException extends TestBase {

   /*
    StaleElementReferenceException
    ==>Bu hatayi neden aliriz?
        Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde store ettikten sonra o sayfada
        herhangi bir yenileme islemi yapildiginda (navigate.refresh(), back(), forward()) locate ini aldigimiz webelementi
        tekrar kullanmnak istersek bu exceptionu aliriz

    ==>Bu hatayi nasil handle ederiz?
        Bu exceptionu handle edebilmek icin elementin locate ini refresh(), back(), forward() gibi methodlar kullandiktan
        sonra tekrar almamiz gerekir
     */

    /*
    ==> InvalidSelectorException -> Belirtilen bir locator gecersiz oldugunda ortaya cikar
    ==> WebDriverException -> Webdriver ile ilgili kurulum, yada versiyon uyumsuzluklari
    ==> ElementClickInterceptedException ->Bir webelementin baska bir webelement(pop-up, reklam) tarafindan engellenmesi
    ==> ElementNotInteractable -> Bir webelement uzerinde cesitli islemler yapmaya elverisli degilse
    ==> InvalidArgumentException -> Bakiniz test methodu 3. gecersiz datanin methoda gönderilmesi
     */

    @Test
    public void test03() {
        //   driver.get("32654654654amazcom");
    }

    @Test
    public void test01() {

        //amazon websayfasina gidelim
        driver.get("https://amazon.com");

        //arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        waitForSecond(2);

        //ana sayfaya dönelim
        driver.navigate().back();
        waitForSecond(2);

        //arama kutusunda desktop aratalim
        WebElement searchBox2 = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox2.sendKeys("desktop");
        searchBox2.submit();

    }



    @Test
    public void test05() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

        for (int i = 0; i < products.size(); i++) {

            // products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            products.get(i).click();
            Thread.sleep(2000);
            System.out.println(i + 1 + ". title: " + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }

    }


}
