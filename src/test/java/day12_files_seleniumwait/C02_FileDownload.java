package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void fileDownloadTest() {

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        String dynamicPath =  System.getProperty("user.home") +"\\Downloads\\b10 all test cases, code.docx";
        // Files.delete(Paths.get(dynamicPath)); kodu belirtilen yoldaki dosyayi eger var ise siler
        //yoksa IOException firlatir
        try {
            Files.delete(Paths.get(dynamicPath));
        } catch (IOException e) {
            System.out.println("Belirtilen dosya silinemedi!!!");
        }
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test case")).click();
        waitForSecond(5);
        //Dosyanın başarıyla indirilip indirilmediğini test edelim


        Assert.assertTrue(Files.exists(Paths.get(dynamicPath)));


    }
}
