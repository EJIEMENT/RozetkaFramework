package pages;

import decorator.InputBox;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@name = \"search\"]")
    private InputBox searchField;

    public void findItemByName(String itemName) {
        searchField.sendKeys(itemName, Keys.ENTER);
    }

    public HomePage() {
        super();
    }
}
