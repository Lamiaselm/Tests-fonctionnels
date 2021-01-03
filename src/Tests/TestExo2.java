import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestExo2 {

    static WebDriver webDriver;
    @BeforeClass
    public static void setUpBeforeClass(){
        //recuperer le webdriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo Legion\\Downloads\\Tp2\\webDriver/chromedriver.exe");
        //creer le webdriver
        webDriver=new ChromeDriver();
    }


    @Test
    public void test(){
        //acceder au site ebay
        webDriver.get("https://www.ebay.com/");
        //selectionné le search bar
        WebElement searchInput=webDriver.findElement(By.id("gh-ac"));
        //chercher "shoes for men"
        searchInput.sendKeys("Shoes for men");
        //valider la reponse
        searchInput.submit();
        //select product
        webDriver.findElement(
                By.partialLinkText(
                        "New Men's Lace up Athletic Sneakers Sport Shoes Breathable Mesh Running shoes")).click();

        //Sélectionner les caractéristiques du produit
        WebElement color=webDriver.findElement(
                By.id("msku-sel-1"));
        //choisir la color "white"
        Select selectColor=new Select(color);
        selectColor.selectByVisibleText("White");
        //choisir le size "AU 7=EUR 41"
        WebElement size=webDriver.findElement(
                By.id("msku-sel-2"));
        Select selectsize=new Select(size);
        selectsize.selectByVisibleText("AU 7=EUR 41");
        //Choisir quantity ="3"
        WebElement quantity =webDriver.findElement(By.name("quantity"));
        quantity.clear();
        quantity.sendKeys("3");
        //Cliquer sur Add to cart
        WebElement submit = webDriver.findElement(By.id("isCartBtn_btn"));
        submit.click();
        //comparer prix affiché avec le prix attendu
        WebElement price = (new WebDriverWait(webDriver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span")));
        //tester le prix total avec le prix attendu
        Assert.assertTrue(price.getText().equals("AU $32.94"));
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception{
        //quitter le webdriver
        webDriver.quit();
    }
}
