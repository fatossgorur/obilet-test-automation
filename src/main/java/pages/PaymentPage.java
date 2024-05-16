package pages;

import helpers.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BrowserFactory;

import java.util.List;

public class PaymentPage {
    WebDriver driver;
    HelperMethods methods;

    public PaymentPage() {
        driver = BrowserFactory.getChromeDriver();
        PageFactory.initElements(driver, this);
        methods = new HelperMethods();
    }

    @FindBy(css = ".flight-info .origin")
    private List<WebElement> flightInfoOrigin;

    @FindBy(css = ".flight-info .destination")
    private List<WebElement> flightInfoDestination;

    public void controlCurrentPaymentUrl() {
        methods.waitToPageLoad();
        Assert.assertTrue(methods.getCurrentUrl().contains("odeme"));
    }

    public void controlDepartureFlights(String originCity, String destinationCity) {
        Assert.assertTrue(methods.getTextAtIndex(flightInfoOrigin, 0).contains(originCity));
        Assert.assertTrue(methods.getTextAtIndex(flightInfoDestination, 0).contains(destinationCity));
    }

    public void controlReturnFlights(String originCity, String destinationCity) {
        Assert.assertTrue(methods.getTextAtIndex(flightInfoOrigin, 1).contains(destinationCity));
        Assert.assertTrue(methods.getTextAtIndex(flightInfoDestination, 1).contains(originCity));
    }
}
