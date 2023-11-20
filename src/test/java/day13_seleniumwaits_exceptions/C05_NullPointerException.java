package day13_seleniumwaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C05_NullPointerException {

    /*
    NullPointerException
    Eger bir object yada bir variable olusturup bu object yada variable a assignment yapmadan kullanmak isterseniz
    bu exception u alirsiniz

     */
    Faker faker;

    @Test
    public void test01() {
        faker = new Faker();

        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());


    }
}
