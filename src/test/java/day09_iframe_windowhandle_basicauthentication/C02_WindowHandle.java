package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {
        /*
        Eger bir sayfaya gittikten sonra yeni sekme yada yeni bir pencere acmak istersek bunun icin driver.switchTo().newWindow() methodunu kullanmaliyiz
        bu method parantez icinde yeni acilacak olan sayfanin bir sekmemi yoksa yeni bir penceremi oldugunu asagidaki kodlar ile yapabilirz

        1-driver.switchTo().newWindow(WindowType.WINDOW) yeni bir penecere acar ve buraya gecis yapar
        2-driver.switchTo().newWindow(WindowType.TAB) yeni bir sekme acar ve buraya gecis yapar

        eger window handle degeri ile bir sayfaya gecis yapmak istersek bu defada driver.switchTo().window() methodunu kullaniriz
        ve gecis yapmak istedigimiz sayfanin window handle degerini belirtmemiz gerekir

     */

    @Test
    public void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "TechPro Education" olduğunu doğrulayın
        String expectedTitle = "TechPro Education";
        String actualTitle = driver.getTitle();
        String techProHandle = driver.getWindowHandle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techProHandle);
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        waitForSecond(2);

    }


    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "TechPro Education" olduğunu doğrulayın
        String expectedTitle = "TechPro Education";
        String actualTitle = driver.getTitle();
        String techProHandle = driver.getWindowHandle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techProHandle);
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        waitForSecond(2);

    }


    @Test
    public void test03() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "TechPro Education" olduğunu doğrulayın
        String expectedTitle = "TechPro Education";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        List<String> windows = new ArrayList<>(driver.getWindowHandles());


        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(windows.get(0));
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(windows.get(1));
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(windows.get(2));
        waitForSecond(2);
  /*
        Acilmis olan tum pencerelerin window handle degelerini getWindowHandles() methodu ile aldik.
        Bu method bir Set return eder, ama setlerde index kullanarak istedgimiz elemani secmek mumkun degildir
        Bu yüzden  bizde bu seti kullanarak bir tane list olusturduk, bu seti liste dönüstürmüs olduk
        Çünkü List lerde get methodu sayesinde index ile istedigimiz pencereye gecis yapabiliriz
         */

    }


    @Test
    public void test04() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "TechPro Education" olduğunu doğrulayın
        String expectedTitle = "TechPro Education";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");



        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        waitForSecond(2);
    }

}
