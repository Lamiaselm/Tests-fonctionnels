package WebElements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PricePage extends PageObject {


    public PricePage(WebDriver driver) {
        super(driver);
    }
    public void CheckPrice () {
        WebElement price = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span")));

        Assert.assertTrue(price.getText().equals("AU $32.94"));

    }
}
