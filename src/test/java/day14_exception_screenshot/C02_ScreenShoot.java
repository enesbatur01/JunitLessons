package day14_exception_screenshot;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_ScreenShoot extends TestBase {

    /*
    1- Almak istedigimiz ekran gorunutusunu kaydetmek icin bir dosya yolu belirleriz
    2- TakeScreenShot interfacinden bir obje deklare ederek driver i bu objeye assign edeceğiz
    3- Files classindan write() methodunu kullanarak icine parametre olarak neyi nereyey kaydedelim bunu belirtiriz
        getScreenShotAs() methodu ile ekran gorunutusunu alarak bu gorunutuyu kaydetmek icin almis oldugumuz dosya yolunu beliritiriz
     */




    @Test
    public void test01() throws IOException {

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        //Sayfanin ekran gorunutusunu aliniz
        String filePath = "src\\test\\java\\screenShots\\amazon.png";

        TakesScreenshot ts = (TakesScreenshot) driver;

        Files.write(Paths.get(filePath),ts.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    public void test02() throws IOException {
        driver.get("https://techproeducation.com");
        String filePath = "src\\test\\java\\screenShots\\techpro.jpg";

        TakesScreenshot ts = (TakesScreenshot) driver;


        Files.write(Paths.get(filePath),ts.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    public void test03() throws IOException {
        driver.get("https://facebook.com");

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String filePath ="src\\test\\java\\screenShots\\fb_"+date+".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(filePath),ts.getScreenshotAs(OutputType.BYTES));
    }
}
