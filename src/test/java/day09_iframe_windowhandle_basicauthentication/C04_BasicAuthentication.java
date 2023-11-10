package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //    Congratulations! You must have the proper credentials. yazının çıktığını doğrulayın
        //Elemental Selenium linkine tıklayınız
        driver.findElement(By.xpath("//p")).isDisplayed();//TestBase deki window methodu ile yeni acilan sayfaya rahatlikla erisim sagladik

        //Başlığın Elemental Selenium içerdiğini test edelim
        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();
        window(1);
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains("Elemental Selenium"));




    }
}
