package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {
    protected WebDriver driver;
    protected ExtentReports extentReports; //raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//html formatında rapor oluşturur
    protected ExtentTest extentTest;//test adımlarına bilgi eler
    public void rapor(String browser,String reportName){


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
            extentHtmlReporter.config().setReportName(reportName);

            //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi aşağıdaki formatta ekleyebiliriz
            extentReports.setSystemInfo("Enviroment","QA");
            extentReports.setSystemInfo("Browser",browser);
            extentReports.setSystemInfo("Test Automation Engineer","Enes Burak Batur");

            //"AmazonTest" Adında bir test oluşturur ve bu testin açıklaması oalrak "Test Report" ekler
            extentTest=extentReports.createTest("AmazonTest","Test Report");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    //Select Visible Text DropDown
    public void selectVisibleDDM(WebElement dropdown,String option){
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    //Select Value DropDown
    public void selectValueDDM(WebElement dropdown,String option){
        Select select = new Select(dropdown);
        select.selectByValue(option);
    }


    //Hard Wait
    public void waitForSecond(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Window Handles
    public void window(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //iframe index
    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }

    //screenshot
    public void screensShot()  {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String filePath ="src\\test\\java\\screenShots\\"+date+"screenShot.png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(filePath),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //webelement screenshot
    public void getScreenshotOfWebelement (WebElement element){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now());
        String filePath = "src\\test\\java\\screenShots\\"+date+"__webelementSS.png";
        try {
            Files.write(Paths.get(filePath),element.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
