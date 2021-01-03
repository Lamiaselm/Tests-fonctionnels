package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CaracteristiquePage extends  PageObject {

    @FindBy(id="msku-sel-1") private WebElement color;
    @FindBy(id="msku-sel-2") private WebElement size;
    @FindBy(name="quantity") private WebElement quantity;
    @FindBy(id="isCartBtn_btn") private WebElement submit;

    public CaracteristiquePage(WebDriver driver) {
        super(driver);
    }

    public void SelectColor (String value){
        Select selectColor=new Select(this.color);
        selectColor.selectByVisibleText("White");
    }
    public void SelectSize (String value){
        Select selectColor=new Select(this.size);
        selectColor.selectByVisibleText("AU 7=EUR 41");
    }
    public void SelectQuantity (String value){

        this.quantity.clear();
        this.quantity.sendKeys("3");
    }
    public void Submit (){
      this.submit.click();
    }




}
