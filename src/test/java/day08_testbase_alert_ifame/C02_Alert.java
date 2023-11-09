package day08_testbase_alert_ifame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {
     /*
    Eger bir sayafadaki bir buttona tikladiginizda bir uyari cikiyorsa ve bu cikan uyariya sag click yaparak locate alamiyorsak bu bir JS Alert tür
    JS Alertü handle edebilmek icin driveri mizi o acilan pencereye gecirmemiz gerekir
    driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alerte gecis yapmis oluruz

    1) accept() yada dismiss() methodlariyla JS Alert ü onaylar yada iptal ederek kapatiriz

    accept() -->onaylar
    dismiss() --> iptal eder
     */

        /*
        https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

    Bir metod olusturun: acceptAlert
           1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.

    Bir metod olusturun: dismissAlert
           2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
           “successfuly” icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
           3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
           tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */


    @Test
    public void test01(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[1]")).click();
        waitForSecond(2);
        driver.switchTo().alert().accept();
        String expectedData = "You successfully clicked an alert";
        String actualData= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedData,actualData);
    }
    @Test
    public void test02(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[2]")).click();
        driver.switchTo().alert().dismiss();
        String unExpectedData="successfuly";
        String actualData= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertFalse(actualData.contains(unExpectedData));
    }
    @Test
    public void test03(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[3]")).click();
        driver.switchTo().alert().sendKeys("Enes Burak Batur");
        driver.switchTo().alert().accept();
        String expectedData="Enes Burak Batur";
        String actualData= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualData.contains(expectedData));
    }
}
