package day15_screenshot_extentreport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test01() {

        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //ekran resmi aliniz
        screensShot();
    }

    @Test
    public void webElementScreenShot() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();
        //ekran resmini alalım
        screensShot();
        //sonuc yazısı webelementinin resmini alalım
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        WebElement result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String filePath = "src\\test\\java\\screenShots\\"+date+"webelementSS.png";
        Files.write(Paths.get(filePath),result.getScreenshotAs(OutputType.BYTES));

        /*
        Bir webelementin ekran görüntüsü nasıl alınır?
        Selenium 4 ile birlikte artık biz bir webelementin ekran görüntüsünü getScreenshotAs methodu sayesinde alabiliyoruz
         */




    }
    @Test
    public void webElementScreenShot2() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();
        //ekran resmini alalım
        screensShot();
        //sonuc yazısı webelementinin resmini alalım
        WebElement result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        getScreenshotOfWebelement(result);

        /*
        Bir webelementin ekran görüntüsü nasıl alınır?
        Selenium 4 ile birlikte artık biz bir webelementin ekran görüntüsünü getScreenshotAs methodu sayesinde alabiliyoruz
         */




    }
}
