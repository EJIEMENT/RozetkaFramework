package decorator;

import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }
    public String getText(){
        return webElement.getText();
    }
}
