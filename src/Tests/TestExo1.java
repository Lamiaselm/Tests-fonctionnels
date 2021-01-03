

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestExo1{

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //recuperer le webdriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo Legion\\Downloads\\Tp2\\webDriver/chromedriver.exe");
        //creer le webdriver
        driver = new ChromeDriver();
        //acceder au site ebay
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void test() {
        //recuperer le button et clique dessus
        WebElement button = driver.findElement(By.id("gh-shop-a"));
        button.click();
        //choisisr categorie Kids toys et selectionne le
        WebElement link = driver.findElement(By.linkText("Kids toys"));
        link.click();
        // choisisr brand et selectionne le
        WebElement link2 = driver.findElement(By.linkText("Action"));
        link2.click();
        //choisir 'Car' comme type de véhicule
        WebElement type = driver.findElement(By.linkText("Car"));
        type.click();
        //choisir marque toyota
        WebElement toyota = driver.findElement(By.linkText("Toyota"));
        toyota.click();
        //recuperer la liste des produits
        List<WebElement> myElement =  (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("s-item__image-section")));
        //tester le nb d'elements de la liste des produits
        Assert.assertEquals(myElement.size(),7);
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        //quitter le webdriver
        driver.quit();


    }


}
