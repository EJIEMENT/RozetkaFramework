package pages;

import decorator.Button;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//app-buy-button//button[contains (@class ,\"buy-button button button\")]")
    private Button buyButton;

    public void clickOnByButton() {
        buyButton.click();
    }

    public ProductPage() {
        super();
    }
}
