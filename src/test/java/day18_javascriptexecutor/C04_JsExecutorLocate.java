package day18_javascriptexecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsExecutorLocate extends TestBase {
    @Test
    public void test01() {

        // https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html   adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini locate edelim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js.executeScript("return document.getElementById('content');");

        System.out.println(element.getText());

    }
    @Test
    public void test02() {
        //amazon a gidin
        driver.get("https://amazon.com");
        //arama kutusunda selenium yazin
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("selenium");

        //arama kutusuna basarili bir sekilde yazinin gönderildigini test edin
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String actualData=js.executeScript("return document.getElementById('twotabsearchtextbox').value;").toString();
        String expectedData="selenium";
        Assert.assertEquals(expectedData,actualData);

        String actualType=js.executeScript("return document.getElementById('twotabsearchtextbox').type;").toString();
        System.out.println(actualType);
        String actualName=js.executeScript("return document.getElementById('twotabsearchtextbox').name;").toString();
        System.out.println(actualName);
        String actualClassName=js.executeScript("return document.getElementById('twotabsearchtextbox').className;").toString();
        System.out.println(actualClassName);
    }
}
