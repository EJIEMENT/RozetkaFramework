package pages;

import decorator.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//section[@class = 'content content_type_catalog']")
    private List<WebElement> laptopCatalog;

    public void clickOnFindProduct() {
        laptopCatalog.stream().findFirst().get().click();
    }

    public CatalogPage() {
        super();
    }
}
