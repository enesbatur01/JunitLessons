package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait_WebDriverWait extends TestBase {
     /*
    Selenium Waits

    1) Implicitly wait :
        Bir websayfasina gittikten sonra sayfadaki tüm webelementlerin driver ile etkilesime girebilmesi icin belirtmis
        oldugumuz maximum süre kadar driver i bekletiriz

    2) Explicit wait :

      a) WebDriverWait
        Sayfa yuklendikten sonra bir webelementle ilgili specific bir kosul icin maximum belirtmis oldugumuz süre kadar
        bekletiriz.Bu süre default olarak yarim saniyelik araliklar ile olur

        Bu kosulun gerceklesmesi farkli sürelerde meydana gelebilir,böyle bir durumda Thread.sleep kullanmak profosyonel bir
        yaklasim olmaz. Bunun yerine Webdriverwait ile bir webelementin olusmasini beklemek daha mantikli olur


        b) FluenWait
        Bir webelementin sayfa yüklendikten sonra etkilesime gecebilmesi icin maximum belirtmis oldugumuz sure kadar bizim
        belirttigimiz araliklarla bekler


     */

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        /*
        1- helloworld webelementini gorunur olana kadar beklemek istiyoruz bu neden bu elementi locate ettik
        2- Webdriverwait objesi olusturduk ve constructor icinde driver ve Maximumum ne kadar bekletilsin bunu belirledik
        3- Olusturdugumuz wait objesi uzerinden senaryomuza özel bir kosul methodu sectik, ve bu sayede bekleme islemini
        kosula baglayarak gereksiz beklemelerin onüne gecmis olduk ve daha dynamic olarak bekleme sagladik
         */


        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//*[.='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertEquals("Hello World!",helloWorld.getText());

    }

    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et

        /*
        Locate ini aldigimiz webelement gorunur olana kadar bekle dedik
        eger belirtilen sure icinde aradigimiz webelement gorunur hale gelirse bu kod o webelementi bize verir
        eger belirtilen sure icinde gorunur hale gelmezse o zamanda TimeOutException hatasi firlatir
         */

        WebElement helloWorld = new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Hello World!']")));

        Assert.assertEquals("Hello World!",helloWorld.getText());

    }

    @Test
    public void test03() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//*[.='Hello World!']"));

        WebElement loading = driver.findElement(By.xpath("//*[.='Loading... ']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loading));
        Assert.assertEquals("Hello World!",helloWorld.getText());

    }
    }

