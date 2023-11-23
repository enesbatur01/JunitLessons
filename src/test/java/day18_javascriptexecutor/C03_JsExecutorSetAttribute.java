package day18_javascriptexecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutorSetAttribute extends TestBase {
    @Test
    public void test01() {

        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdiralim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        js.executeScript("arguments[0].value='selenium'",searchBox);

    }
    @Test
    public void test02() {

        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        jsSendKeys("selenium",searchBox);


    }
}
