package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Locale;

public class C06_FakerTest extends TestBase {

 /*
    Locale locale = new Locale("tr");
    Faker faker1 = new Faker(locale);
    System.out.println("faker1.name().firstName() = " + faker1.name().firstName());

    ==> Eger belli bir bolgeye özel fake datalar olusturmak istersek mesela turkiye icin Locale classindan bir obje olustururuz
    ve olusturmus oldugumuz objeyi faker constructoru icinde beliritiriz
    bu sayade belirtilen bölgeye özel datalar elde edebiliriz
     */

    @Test
    public void name() {
        Locale locale = new Locale("tr");
        Faker faker = new Faker(locale);
        System.out.println("fake ilk isim = " + faker.name().firstName());
    }

    @Test
    public void test() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account"  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //"firstName" giris kutusuna bir isim yazin
        //"lastname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin

        Faker faker = new Faker();

        String email = faker.internet().emailAddress();
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys(
                faker.name().firstName(), Keys.TAB,
                faker.name().lastName(), Keys.TAB,
                email, Keys.TAB);

        waitForSecond(3);

        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin

//1.yol
        WebElement emailTekrar= driver.findElement(By.xpath("//*[@name='reg_email_confirmation__']"));
        emailTekrar.sendKeys(email, Keys.TAB,
                faker.internet().password(),Keys.TAB,Keys.TAB,
                "15",Keys.TAB,"May",Keys.TAB,"2013",Keys.TAB,Keys.TAB,
                Keys.RIGHT,Keys.ENTER );

//ikinci yol
//        firstName.sendKeys(
//                Keys.TAB,Keys.TAB,Keys.TAB,
//                email, Keys.TAB,
//                faker.internet().password(),Keys.TAB,Keys.TAB,
//                "15",Keys.TAB,"May",Keys.TAB,"2013",Keys.TAB,Keys.TAB,
//                Keys.RIGHT,Keys.ENTER );




    }


}
