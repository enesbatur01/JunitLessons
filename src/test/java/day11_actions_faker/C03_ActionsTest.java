package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {
/*
    Sayfadaki bir webelementi locate ettigmiz halde NoSuchElementException aliyorsak;
    1- Locate i tekrar kontrol ederiz buna ragmen ayni hatayi almaya devam ediyorsak
    2- Wait /Syncronization problemi olabilir, ve cozum icin implictly wait de yeterli sure olduguna emin olmaliyiz, ihtiyaca gore bu süreyi artirabiliriz
    3- Webelementin iframe icinde olup olmadigina bakariz, (alert..) yine ayni hatayi aliyorsak
    4- Driver webelementi goremiyordur, dolayisiyla actions classi kullanarak scroll yaparak yada baska yöntemlerle webelementin gorunur olmasini saglariz

     */


    @Test
    public void actions1() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable");

        //Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        Actions actions = new Actions(driver);
        frameIndex(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.dragAndDrop(drag,drop).perform();//drag webelementini drop webelemenitin uzerine birakir

    }

    @Test
    public void actions2() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable");

        //Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        Actions actions = new Actions(driver);
        frameIndex(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.clickAndHold(drag).// drag webelementini tut ve bekle
                moveToElement(drop).//Drag webelementini drop webelementinin üzerine goruturur
                release().//Basili tuttugumuz webelementi serbest biraktik
                perform();


    }


    @Test
    public void actions3() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable");

        //Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        Actions actions = new Actions(driver);
        frameIndex(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.clickAndHold(drag).
                moveByOffset(139,48).
                release().perform();
    }




}
