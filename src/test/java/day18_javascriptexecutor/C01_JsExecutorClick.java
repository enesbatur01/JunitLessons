package day18_javascriptexecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorClick extends TestBase {
    @Test
    public void test01() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //amazona gidelim
        driver.get("https://amazon.com");
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));
        //sayfadaki sell linkine tiklayalim
        jse.executeScript("arguments[0].click();",sellElement);

    }
    @Test
    public void test02() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //amazona gidelim
        driver.get("https://amazon.com");
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));
        //sayfadaki sell linkine tiklayalim
        jsClick(sellElement);

    }
}
