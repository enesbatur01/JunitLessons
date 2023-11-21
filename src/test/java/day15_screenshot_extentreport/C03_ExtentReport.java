package day15_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_ExtentReport {
    ExtentReports extentReports; //raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//html formatında rapor oluşturur
    ExtentTest extentTest;//test adımlarına bilgi eler

    @Test
    public void extentReportTemplate(){
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

        String date =DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path="target\\extentReport\\"+date+"htmlReport.html";
        extentHtmlReporter=new ExtentHtmlReporter(path);

        //ExtentReports a html raporlayıcıyı ekler, bu raporun html formatında oluşturulmasını sağlar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporunun belge başlığını ayarlar
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Reports");

        //Raporun adını ayarladık, bu raporda görünecek olan genel başlık
        extentHtmlReporter.config().setReportName("Smoke Test");

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi aşağıdaki formatta ekleyebiliriz
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Enes Burak Batur");

        //"AmazonTest" Adında bir test oluşturur ve bu testin açıklaması oalrak "Test Report" ekler
        extentTest=extentReports.createTest("AmazonTest","Test Report");

        //============================Buraya kadar şablon ayarlamaları bitti=========================================
        //Bundan sonra extentTest objecti ile log rapora detaylı işlemeri ekleme işlemleri yapacağız

        //Testin başarılı olduğunu belirtir ve rapora Pass notu ekler
        extentTest.pass("PASS");

        //Testin başarısız olduğunu belirtir ve rapora Fail notu ekler
        extentTest.fail("FAIL");

        //Testle alakalı bilgilendirici not ekler
        extentTest.info("Bilgilendirme notu");

        //Testle ilgili uyarı mesajı ekler,Dikakt edilmesi gereken kısımları ekleyebiliriz
        extentTest.warning("Uyarı mesajı!");

        //Bu mesaj testin atlandığını ve rapora atlama mesajı notu ekler
        extentTest.skip("Atlama mesajı");

        //Test sırasında ciddi bir hata olduğunu belirtir
        extentTest.fatal("Ciddi hata Mesajı");

        //tüm işlemlere nokta koyar bittiğini belirtir
        extentReports.flush();

    }

}
