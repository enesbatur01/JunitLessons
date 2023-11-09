package day08_testbase_alert_ifame;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_TestBaseClassWork extends TestBase {


    @Test
    public void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month= driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day= driver.findElement(By.xpath("//select[@id='day']"));

        selectVisibleDDM(year,"2000");
        waitForSecond(2);
        selectVisibleDDM(month,"February");
        waitForSecond(2);
        selectValueDDM(day,"10");
    }
}
