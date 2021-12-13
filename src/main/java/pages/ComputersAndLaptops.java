package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComputersAndLaptops extends BasePage {
    @FindBy(xpath = "//div[@data-filter-name = 'producer']//div[@class = \"sidebar-search\"]/input")
    private WebElement checkBoxFilter;
    @FindBy(xpath = "//div[@data-filter-name = 'producer']//ul[@class = \"checkbox-filter\"]//label[contains (@for, \"Apple\")]")
    private List<WebElement> modelCheckBox;

    public ComputersAndLaptops(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputItemModel(String itemModel) {
        checkBoxFilter.sendKeys(itemModel);
    }

    public void getFirstProduct() {
        modelCheckBox.stream().findFirst().get().click();
    }
}
