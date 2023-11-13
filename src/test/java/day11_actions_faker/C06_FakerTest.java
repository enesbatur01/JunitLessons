package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_FakerTest extends TestBase {

    @Test
    public void test01() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        Faker faker = new Faker();
        WebElement firstName= driver.findElement(By.xpath("//*[@name='firstname']"));
        String email = faker.internet().emailAddress();
        firstName.sendKeys(
                faker.name().firstName(), Keys.TAB,
                faker.name().lastName(), Keys.TAB,
                email,Keys.TAB);

        waitForSecond(2);

        //“firstName” giris kutusuna bir isim yazin

        //“lastname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin

    }


}
