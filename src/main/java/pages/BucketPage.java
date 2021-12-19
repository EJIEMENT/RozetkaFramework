package pages;

import decorator.Element;
import org.openqa.selenium.support.FindBy;

public class BucketPage extends BasePage {
    @FindBy(xpath = "//div[@class = \"cart-receipt__sum-price\"]/span[1]")
    private Element itemPrice;


    public BucketPage() {
        super();
    }

    public Integer getItemPrice() {
        return Integer.valueOf(itemPrice.getText());
    }
}
