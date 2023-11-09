package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;

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
}
