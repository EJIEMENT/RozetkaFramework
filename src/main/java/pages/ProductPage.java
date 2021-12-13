package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//button[contains (@class ,\"buy-button button button_\")]")
    private WebElement buyButton;

    public void clickOnByButton() {
        buyButton.click();
    }

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }
}
