package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@name = \"search\"]")
    private WebElement searchField;

    public void findItemByName(String itemName){
        searchField.sendKeys(itemName, Keys.ENTER);
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
}
