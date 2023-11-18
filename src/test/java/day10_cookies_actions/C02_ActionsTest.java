package day10_cookies_actions;

import net.bytebuddy.implementation.bind.ParameterLengthResolver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {
    @Test
    public void actions() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        String actualData = driver.switchTo().alert().getText();
        String expectedData = "You selected a context menu";
        Assert.assertEquals("Actual Result ile Expeced Result uyumlu değil",expectedData,actualData);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();

    }
}
