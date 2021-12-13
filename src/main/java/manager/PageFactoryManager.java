package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage geTHomePage() {
        return new HomePage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public CatalogPage getCatalogPage() {
        return new CatalogPage(driver);
    }

    public BucketPage getBucketPage() {
        return new BucketPage(driver);
    }

    public ComputersAndLaptops getComputersAndLaptops() {
        return new ComputersAndLaptops(driver);
    }
}
