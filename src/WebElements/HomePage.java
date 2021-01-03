package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(id="gh-ac") private WebElement searchBar;


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void setWebSite(WebDriver driver, String webSite){
        driver.get(webSite);
    }

    public void setInput( String category){
        searchBar.sendKeys(category);
    }

    public void submit(){
        searchBar.submit();
    }
}
