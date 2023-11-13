package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Locale;

public class C05_Faker {
    @Test
    public void faker() {

        Faker faker = new Faker();
        //faker objesi ile fake bir isim yazdırınız
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //faker objesi ile fake bir soyisim yazdırınız
        String lastName =faker.name().lastName();
        System.out.println("lastName = " + lastName);

        //faker objesi ile fake bir adress yazdırınız
        String address =faker.address().fullAddress();
        System.out.println("address = " + address);

        //faker objesi ile fake bir telefon No yazdırınız
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println("phoneNumber = " + phoneNumber);

        //faker objesi ile fake bir email yazdırınız
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        System.out.println(faker.number().digits(15));

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println(faker.name().fullName());

    }

    @Test
    public void test02() {
        Locale locale = new Locale("tr");
        Faker faker = new Faker(locale);
        System.out.println(faker.name().firstName());
        /*
        Eger belli bir bolgeye ozel fake datalar olusturmak istersek mesela türkiye icin locale classindan bir object olustururuz
        ve olusturmus oldugumuz objeyi faker constructor parantezi icinde belirtiriiz
        bu sayede belirtilen dile ozel datalar elde edebiliriz
         */


    }
}
