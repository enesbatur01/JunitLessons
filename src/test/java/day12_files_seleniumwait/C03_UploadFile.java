package day12_files_seleniumwait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;

public class C03_UploadFile extends TestBase {


    @Test
    public void uploadTest() {


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //Yuklemek istediginiz dosyayi secelim.
        chooseFile.sendKeys(System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx");
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //"File Uploaded!" textinin goruntulendigini test edelim.
        driver.findElement(By.xpath("//h3[.='File Uploaded!']")).isDisplayed();


    }

    }
