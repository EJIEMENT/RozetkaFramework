package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BucketPage extends BasePage {
    @FindBy(xpath = "//div[@class = \"cart-receipt__sum-price\"]/span[1]")
    private WebElement itemPrice;


    public BucketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Integer getItemPrice() {
        return Integer.valueOf(itemPrice.getText());
    }
}
