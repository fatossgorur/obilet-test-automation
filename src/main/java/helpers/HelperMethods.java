package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperMethods {

    private WebDriver driver = BrowserFactory.getChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    public void getUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysElement(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Boolean isDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public Boolean isElementsSize(List<WebElement> elements) {
        return elements.size() > 1;
    }

    public void waitToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public String getTextAtIndex(List<WebElement> elements, int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index).getText();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
    }

    public void clickByContainsText(List<WebElement> elements, String text) {
        boolean clicked = false;
        for (WebElement element : elements) {
            if (getText(element).contains(text)) {
                clickElement(element);
                clicked = true;
                break;
            }
        }
        if (!clicked && !elements.isEmpty()) {
            clickElement(elements.get(0));
        }
    }

    public void clickElementAtIndex(List<WebElement> elements, int index) {
        if (index >= 0 && index < elements.size()) {
            elements.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
    }

}

