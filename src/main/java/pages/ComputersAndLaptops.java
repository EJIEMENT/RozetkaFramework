package pages;

import decorator.Button;
import decorator.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ComputersAndLaptops extends BasePage {
    @FindBy(xpath = "//div[@data-filter-name = 'producer']//div[@class = \"sidebar-search\"]/input")
    private InputBox checkBoxFilter;
    @FindBy(xpath = "//button[@class = \"sidebar-search__clear ng-star-inserted\" ]")
    private Button buttonOut;


    public ComputersAndLaptops() {
        super();
    }

    public void inputItemModel(String itemModel) {
        waitForPageLoadComplete(20);
        checkBoxFilter.sendKeys(itemModel);
    }

    public void selectFirstProduct(String itemModel) {
        webDriver.findElement(By.xpath(String.format("//div[@data-filter-name = 'producer']//ul[@class = \"checkbox-filter\"]//label[contains (@for, \"%s\")]", itemModel))).click();
    }

}
