package pages;

import decorator.CustomFieldDecorator;
import manager.WebDriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        this.webDriver = WebDriverSingleton.getInstance();
        PageFactory.initElements(new CustomFieldDecorator(webDriver), this);
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(webDriver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }
}