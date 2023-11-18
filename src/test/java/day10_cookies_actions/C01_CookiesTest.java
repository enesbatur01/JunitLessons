package day10_cookies_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_CookiesTest extends TestBase {

   /*
    Cookies denildiginde aklimiza ilk gelmesi gereken manage methodudur.
    manage() methodu sayesinde cookieler ile ilgili tum islemler yapilir
     */

    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie'leri consolda bir loop ile yazdirin
        Set<Cookie> cookieSet = driver.manage().getCookies();//mevcut tum cookie leri bir set olarak verir
        // System.out.println(cookieSet);

        int counter = 1;
        for (Cookie w : cookieSet) {
            System.out.println(counter + " . cookie  ==> " + w);
            System.out.println(counter + " . cookie Name  ==> " + w.getName());
            System.out.println(counter + " . cookie Value  ==> " + w.getValue());
            counter++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualSize = cookieSet.size();
        Assert.assertTrue(actualSize>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue =driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue ="USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);


        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        cookieSet = driver.manage().getCookies();

        int counter1 = 1;
        for (Cookie w : cookieSet) {
            System.out.println(counter1 + " . cookie  ==> " + w);
            System.out.println(counter1 + " . cookie Name  ==> " + w.getName());
            System.out.println(counter1 + " . cookie Value  ==> " + w.getValue());
            counter1++;
        }


        //6-eklediginiz cookie'nin sayfaya eklendigini test
        Assert.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();

        int counter2 = 1;
        for (Cookie w : cookieSet) {
            System.out.println(counter2 + " . cookie  ==> " + w);
            System.out.println(counter2 + " . cookie Name  ==> " + w.getName());
            System.out.println(counter2 + " . cookie Value  ==> " + w.getValue());
            counter2++;
        }
        Assert.assertFalse(cookieSet.contains( driver.manage().getCookieNamed("skin") ));



        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//tum cookie leri sildik
        cookieSet = driver.manage().getCookies();//cookiesSet i güncelledik
        Assert.assertTrue(cookieSet.isEmpty());//isEmpty methodu sayesinde setimizin bos oldugunu doğruluyoruz


    }
}
