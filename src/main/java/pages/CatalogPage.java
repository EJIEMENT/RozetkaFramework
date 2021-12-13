package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//section[@class = 'content content_type_catalog']")
    private List<WebElement> laptopCatalog;

    public void clickOnFindProduct() {
        laptopCatalog.stream().findFirst().get().click();
    }

    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }
}
