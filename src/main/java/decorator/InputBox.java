package decorator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InputBox extends Element {
    public InputBox(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String txt, Keys enter) {
        webElement.sendKeys(txt, enter);
    }

    public void sendKeys(String txt) {
        webElement.sendKeys(txt);
    }
}
