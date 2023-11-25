package day19_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Log4j extends TestBase {
    /*
   1-Log4j kullanabilmek icin oncelikle Log4j-core ve log4j-api dependencyleri pom xml dosyasina ekleriz
   2-project seviyesinde birtane log4jxml dosyasi olusturup configurasyon icin xml kodlarini bu dosyaya ekleriz

    */
    @Test
    public void test01() {
        //  LogManager.getLogger(C02_Log4j.class); kodu parantez icinde belirtilen class
        //  icin bir tane Logger(loglayici) objecti olusturur
        Logger logger = LogManager.getLogger(C02_Log4j.class);

        driver.get("https://amazon.com");
        logger.info("amazon web sayfasına gidildi");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("arama kutusu locate edildi");
        searchBox.sendKeys("selenium");
        searchBox.submit();
        logger.info("arama kutusunda selenium aratıldı");




    }
}
