package day07_dropdown_testbase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    /*
    DROPDOW

    Dropdown u automate etmek icin
    1- Dropdown menuyu ilk olarak locate ederiz
    2- Select objesi olusturulur
    3- Select objesi uzerinden cesitli methodlar sayesinde dropdown seceneklerine erisim saglariz

        SYNTAX
        Select select = new Select(Dropdown web elementi);

       Select objecti uzerinden dropdown menuyu handle edebileceğimiz 3 tane method vardir
       a- selectByVisibleText() ->dropdown menudeki elemente gorunur metin ile ulasmak icin kullanilir
       b- selectByIndex() -> Index ile ulasmak icin kullanilir (index 0 (sifir) dan baslar)
       c- selectByValue() -> value attribute degeri ile ulasmak icin kullanilir (option tagi ile baslar)

    4- getOptions() -> Locate ettigimiz dropdown menu deki tum secenekleri bize verir
    5- getFirstSelectedOption() -> Dropdown menudeki secili olan seceneği bize verir

     */
    /*
   Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
   -3 farklı test methodu oluşturalım
       1.Method:
           a. Yil,ay,gün dropdown menu'leri locate ediniz
           b. Select objesi olustur
           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       2.Method:
           a. Tüm eyalet isimlerini yazdıralım
       3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

    */
    WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month= driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day= driver.findElement(By.xpath("//select[@id='day']"));

        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        selectYear.selectByValue("2000");
        selectMonth.selectByValue("1");
        selectDay.selectByValue("10");

    }

    @Test
    public void test02(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement states = driver.findElement(By.xpath("//select[@id='state']"));
        Select selectList = new Select(states);
        List<WebElement> listState = selectList.getOptions();
        //1.yol

        for (WebElement w : listState){
            System.out.println(w.getText());
        }

        //2.yol

        listState.forEach(t-> System.out.println(t.getText()));

    }

    @Test
    public void test03(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement states = driver.findElement(By.xpath("//select[@id='state']"));
        Select selectList = new Select(states);
        String expectedData ="Select a State";
        String actualData = selectList.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedData,actualData);

    }

    @Test
    public void test04() {
        //genellikle dropdown webelementine sendkeys methodu sayesinde herhangi bir seceneği pratik olarak gonderebilirz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement states = driver.findElement(By.xpath("//select[@id='state']"));
        states.sendKeys("Alaska");
    }

    @Test
    public void test05() {
        //x path in gücü ile locatini aldigimiz dropdown un tum seceneklerini bir liste koyduk daha sonrada yazdirdik
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        List<WebElement> stateList = driver.findElements(By.xpath("//select[@id='state']/option"));
        stateList.forEach(t-> System.out.println(t.getText()));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
