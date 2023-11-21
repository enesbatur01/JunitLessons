package day15_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ExtentReportTest extends TestBase {
    ExtentReports extentReports; //raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//html formatında rapor oluşturur
    ExtentTest extentTest;//test adımlarına bilgi eler

    @Test
    public void extentReportTemplate() {
        /*
    1- ExtentReport classından raporlamayı başlatması için bir object oluşturmalıyız
    2- ExtentHtmlReporter classından raporları html formatinda oluşturması için bir object oluşturmalıyız
    3- ExtentTest classından test adımlarına bilgi ekleyebilmek için bir object oluştururuz
     */

        //bu objecti raporları oluşturmak ve yönetmek için kullanacağız
        extentReports = new ExtentReports();

        //öncelikle oluşturmak istediğimiz html reportu projemizde enrede saklamak istiyorsak bir dosya yolu oluşturmalıyız
        //çünkü bu pathi kullanarak bir tane html report oluşturacağız
        //bunun içinde ExtentHtmlReporter classindan bir object oluşturmalıyız

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target\\extentReport\\" + date + "htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a html raporlayıcıyı ekler, bu raporun html formatında oluşturulmasını sağlar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporunun belge başlığını ayarlar
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Reports");

        //Raporun adını ayarladık, bu raporda görünecek olan genel başlık
        extentHtmlReporter.config().setReportName("Smoke Test");

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi aşağıdaki formatta ekleyebiliriz
        extentReports.setSystemInfo("Enviroment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Enes Burak Batur");

        //"AmazonTest" Adında bir test oluşturur ve bu testin açıklaması oalrak "Test Report" ekler
        extentTest = extentReports.createTest("TechproEducationTest", "Test Report");

        //============================Buraya kadar şablon ayarlamaları bitti=========================================
        //Bundan sonra extentTest objecti ile log rapora detaylı işlemeri ekleme işlemleri yapacağız


        //TechproEducation sayfasina gidelim
        driver.get("https://techproeducation.com/");
        extentTest.info("Kullanıcı techproEducation sayfasına gider");

        //TechproEducation ana sayfada oldugunuzu dogrulayin
        String expectedUrl="https://techproeducation.com/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
        extentTest.info("Kullanıcı ana sayfada olduğunu doğrular");
        extentTest.pass("Ana sayfa url testi başarılı");

        //Ana Sayfa sag üst kısımda sosyal medya iconlarinin goruntulendigini dogrulayin
        WebElement icons=driver.findElement(By.xpath("//*[@class='toolbar-sl-share']"));
        Assert.assertTrue(icons.isDisplayed());
        extentTest.info("Kullanıcı iconların olduğunu doğrular");
        extentTest.pass("iconlar görüntülendi");

        extentReports.flush();




    }
}