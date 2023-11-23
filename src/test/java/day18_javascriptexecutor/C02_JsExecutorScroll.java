package day18_javascriptexecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorScroll extends TestBase {
    @Test
    public void test01() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");
        //Challenges a kadar scroll yapiniz
        WebElement challangesElement = driver.findElement(By.xpath("//h2[.='Challenges']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",challangesElement);

    }
    @Test
    public void test02() {

        //techproeducation a gidelim
        driver.get("https://techproeducation.com");

        //sayfanin en altina scroll yapalim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");


        waitForSecond(2);


        //sayfanin en ustune scroll yapalim
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    public void test03() {

        //techproeducation a gidelim
        driver.get("https://techproeducation.com");

        //sayfanin en altina scroll yapalim
        jsScrollToEnd();

        waitForSecond(2);
        //sayfanin en ustune scroll yapalim
        jsScrollToHome();

    }
}
