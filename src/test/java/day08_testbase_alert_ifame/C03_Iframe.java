package day08_testbase_alert_ifame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Iframe extends TestBase {

    /*
    Bir HTML ökümaninin icine yerlestirilmis baska bir html dökümanina inline Frame (iframe) denir
    iframei handle etmek icin driverimizi iframe gecis yaptirmamiz gerekir

    Üc farkli yöntemle iframe e gecis yapabiliriz
    1)driver.switchTo.frame( sayafadaki iframe in index i (index 0 dan baslar)   )
    2)driver.switchTo.frame( <iframe> tagindaki id / name atrribut degeri   )
    3)driver.switchTo.frame(  iframe in locate  )

    Tekrar ana sayfaya gecmek istersek defaultContent() methodu ile iframe den cikip ana sayfaya geceriz
    Eger ic ice iframe lere gecis yaptiysak  bir ust frame gecis yaptirmak icin parentFrame() methodunu kullaniriz
     */

    @Test
    public void test() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String actualData1 = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        String expectedData1 = "black border";
        Assert.assertTrue(actualData1.contains(expectedData1));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        WebElement applicationListWE = driver.findElement(By.xpath("//*[.='Applications lists']"));
        applicationListWE.isDisplayed();

        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().defaultContent();
        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        iframeText.isDisplayed();


    }
}
