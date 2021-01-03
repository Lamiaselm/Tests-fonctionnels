package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {

    @FindBy(partialLinkText="New Men's Lace up Athletic Sneakers Sport Shoes Breathable Mesh Running shoes")
    WebElement product;
    public ProductPage(WebDriver driver){
        super(driver);
    }

    public  WebElement getProduct(WebDriver driver){

        return this.product;
    }


    public  void selectProduct(WebElement product){
        this.product.click();
    }
}
