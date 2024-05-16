package pages;

import helpers.HelperMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BrowserFactory;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    HelperMethods methods;

    public SearchResultPage() {
        driver = BrowserFactory.getChromeDriver();
        PageFactory.initElements(driver, this);
        methods = new HelperMethods();
    }

    @FindBy(css = ".ins-close-button")
    private WebElement discountCodePopUp;
    @FindBy(css = "#outbound-journeys .one-way")
    private WebElement departureFlightList;

    @FindBy(css = "#outbound-journeys .flys")
    private WebElement departureFlightClassPanel;

    @FindBy(css = "#return-journeys .flys")
    private WebElement returnFlightClassPanel;

    @FindBy(css = "#outbound-journeys .one-way:nth-child(1)")
    private WebElement firstDepartureFlight;

    @FindBy(css = "#outbound-journeys .one-way:nth-child(1) .title .name")
    private List<WebElement> firstDepartureFlightClassList;

    @FindBy(css = "#return-journeys .one-way:nth-child(1)")
    private WebElement firstReturnFlight;

    @FindBy(css = "#return-journeys .one-way:nth-child(1) .title .name")
    private List<WebElement> firstReturnFlightFlightClassList;

    public void selectDepartureFlight() {
        methods.clickElement(firstDepartureFlight);
    }

    public void selectDepartureFlightClass(String flightClass) {
        methods.waitToElement(departureFlightClassPanel);
        methods.clickByContainsText(firstDepartureFlightClassList, flightClass);
    }

    public void controlDepartureFlightClass() {
        methods.isElementsSize(firstDepartureFlightClassList);
    }

    public void controlReturnFlightClass() {
        methods.isElementsSize(firstReturnFlightFlightClassList);
    }

    public void controlFlightList() {
        methods.waitToElement(departureFlightList);
        methods.isDisplayed(departureFlightList);
    }

    public void closeDiscountPopUp() {
        int retryCount = 3;
        int attempts = 0;

        while (attempts < retryCount) {
            try {
                if (methods.isDisplayed(discountCodePopUp)) {
                    methods.clickElement(discountCodePopUp);
                    break;
                }
            } catch (NoSuchElementException | TimeoutException e) {
                attempts++;
            }
        }
    }

    public void selectReturnFlight() {
        methods.clickElement(firstReturnFlight);
    }

    public void selectReturnFlightClass(String flightClass) {
        methods.waitToElement(returnFlightClassPanel);
        methods.clickByContainsText(firstReturnFlightFlightClassList, flightClass);
    }
}
