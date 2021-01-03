import WebElements.CaracteristiquePage;
import WebElements.HomePage;
import WebElements.PricePage;
import WebElements.ProductPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExo3 {
    public static WebDriver driver;
    String id="gh-ac";
    String partialLinkText= "New Men's Lace up Athletic Sneakers Sport Shoes Breathable Mesh Running shoes";
    String website="https://www.ebay.com/";
    String category="Shoes for men";

    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo Legion\\Downloads\\Tp2\\webDriver/chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void SelectTest(){
        //creer une instance de premier page de ebay
        HomePage home=new HomePage(driver);
        //acceder au site ebay
        home.setWebSite(driver,website);
        //chercher "shoes for men"
        home.setInput(category);
        //validé la recherche
        home.submit();
        //creer une instance pour la page des produits
        ProductPage product=new ProductPage(driver);
        product.selectProduct(product.getProduct(driver));
        //creer une instance pour la page caracteristiques de produit
        CaracteristiquePage caracteristiquePage = new CaracteristiquePage(driver);
        //choisir color
        caracteristiquePage.SelectColor("White");
        //choisir size
        caracteristiquePage.SelectSize("AU 7=EUR 41");
        //choisir quantitie
        caracteristiquePage.SelectQuantity("3");
        caracteristiquePage.Submit();
        //creer une instance pour la page de prix total de panier
        PricePage pricePage = new PricePage(driver);
        //verifier le prix total de produit avec le prix attendu
        pricePage.CheckPrice();
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception{
        //quitter le webdriver
        driver.quit();
    }
}
