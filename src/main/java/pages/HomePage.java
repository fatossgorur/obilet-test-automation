package pages;

import helpers.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BrowserFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;
    HelperMethods methods;

    public final String myAccountName = "Hesabım";

    public HomePage() {
        driver = BrowserFactory.getChromeDriver();
        PageFactory.initElements(driver, this);
        methods = new HelperMethods();
    }

    @FindBy(css = "a.login")
    private WebElement homePageLoginButton;

    @FindBy(css = "button.login-to-register")
    private WebElement loginToRegisterButton;

    @FindBy(css = "div.ob-modal")
    private WebElement membershipPopUp;

    @FindBy(css = "div.user-sign-up")
    private WebElement userSignUpHeader;
    @FindBy(css = "input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "button.register-button")
    private WebElement signUpButton;

    @FindBy(css = "#can-use-contract-information")
    private WebElement contractInformation;
    @FindBy(css = "a.user-name")
    private WebElement userName;

    @FindBy(css = "ul.menu a[href='/ucak-bileti']")
    private WebElement flightTab;
    @FindBy(css = "input#origin-input")
    private WebElement flightOrigin;

    @FindBy(css = "#origin > div.results")
    private WebElement flightOriginList;

    @FindBy(css = "div.origin ul > li.item:nth-child(2)")
    private WebElement flightOriginAllAirport;

    @FindBy(css = "input#destination-input")
    private WebElement flightDestination;

    @FindBy(css = "#destination > div.results")
    private WebElement flightDestinationList;

    @FindBy(css = "div.destination ul > li.item:nth-child(2)")
    private WebElement flightDestinationAllAirport;

    @FindBy(css = "div.departure div.input-group")
    private WebElement departureDate;
    @FindBy(css = "div.return div.input-group")
    private WebElement returnDate;
    @FindBy(css = "div.double-picker")
    private WebElement datePicker;
    @FindBy(css = "th.current")
    private List<WebElement> dateMonthYear;

    @FindBy(css = "div.calendar-right th.next")
    private WebElement dateMonthForwardButton;

    @FindBy(css = "div.calendar-left button[type='button']")
    private List<WebElement> calendarLeftDay;

    @FindBy(css = "div.calendar-right button[type='button']")
    private List<WebElement> calendarRightDay;

    @FindBy(css = "#search-button")
    private WebElement searchFlightButton;

    public void navigateToBiletHomePage(String baseUrl) {
        methods.getUrl(baseUrl);
    }

    public void controlHomePageTitle(String homePageTitle) {
        String homePageTitleText = methods.getTitle();
        Assert.assertEquals(homePageTitle, homePageTitleText);
    }

    public void clickHomePageLoginButton() {
        methods.clickElement(homePageLoginButton);
    }

    public void clickLoginToRegisterButton() {
        methods.waitToElement(membershipPopUp);
        methods.clickElement(loginToRegisterButton);
    }

    public void enterMailPasswordAndClickSignUpButton(String mail, String password) {
        methods.sendKeysElement(emailInput,mail);
        methods.sendKeysElement(passwordInput,password);
        methods.clickElement(contractInformation);
        methods.clickElement(signUpButton);
    }

    public void controlSuccessfullyUserCreated() {
        methods.waitToElement(userName);
        String userNameText = methods.getText(userName);
        Assert.assertEquals(myAccountName, userNameText);
    }

    public void controlCurrentSearchFlightUrl() {
        Assert.assertTrue(methods.getCurrentUrl().contains("ucak"));
    }
    public void clickFlightTab() {
        methods.clickElement(flightTab);
    }

    public void selectDepartureCityFlight(String origin) {
        methods.sendKeysElement(flightOrigin,origin);
        methods.waitToElement(flightOriginList);
        methods.clickElement(flightOriginAllAirport);
    }
    public void selectDestinationCityFlight(String destination) {
        methods.sendKeysElement(flightDestination,destination);
        methods.waitToElement(flightDestinationList);
        methods.clickElement(flightDestinationAllAirport);
    }

    public void selectDepartureDate(String monthAndYear, int day){
        methods.clickElement(departureDate);
        methods.waitToElement(datePicker);

        while (!(methods.getTextAtIndex(dateMonthYear, 0).equals(monthAndYear) || methods.getTextAtIndex(dateMonthYear, 1).equals(monthAndYear))) {
            methods.clickElement(dateMonthForwardButton);
        }
        if (methods.getTextAtIndex(dateMonthYear, 0).equals(monthAndYear)) {
            methods.clickElementAtIndex(calendarLeftDay, day-1);
        } else {
            methods.clickElementAtIndex(calendarRightDay, day-1);
        }
    }

    public int dateDay(String date) {
        String[] splitDate = date.split(" ");
        return Integer.parseInt(splitDate[0]);
    }

    public String dateMonthAndYear(String date) {
        String[] splitDate = date.split(" ");
        return splitDate[1] + " " + splitDate[2];
    }


    public void selectDestinationDate(String monthAndYear, int day) {
        methods.clickElement(returnDate);
        methods.waitToElement(datePicker);

        while (!(methods.getTextAtIndex(dateMonthYear, 0).equals(monthAndYear) || methods.getTextAtIndex(dateMonthYear, 1).equals(monthAndYear))) {
            methods.clickElement(dateMonthForwardButton);
        }
        if (methods.getTextAtIndex(dateMonthYear, 0).equals(monthAndYear)) {
            methods.clickElementAtIndex(calendarLeftDay, day-1);
        } else {
            methods.clickElementAtIndex(calendarRightDay, day-1);
        }
    }

    public void clickSearchButton() {
        methods.clickElement(searchFlightButton);
        methods.waitToPageLoad();
    }
}
