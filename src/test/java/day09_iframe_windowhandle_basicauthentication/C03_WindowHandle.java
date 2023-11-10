package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {

    @Test
    public void test01(){
        //  https://the-internet.herokuapp.com/windows adresine gidin.
       driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfasının Handle degerini alın yazdırın
        String firstPageHandle = driver.getWindowHandle();
        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);
        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        driver.switchTo().window(tabs.get(1));
        String actualNewTabTitlte=driver.getTitle();
        String expectedNewTabTitlte = "New Window";
        Assert.assertEquals(expectedNewTabTitlte,actualNewTabTitlte);
        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(tabs.get(0));

        Assert.assertEquals("The Internet",driver.getTitle());
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(tabs.get(1));
        waitForSecond(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(tabs.get(0));
        waitForSecond(2);
    }
    @Test
    public void test02() {

    }
    @Test
    public void test03() {

    }
    @Test
    public void test04() {

    }
}
