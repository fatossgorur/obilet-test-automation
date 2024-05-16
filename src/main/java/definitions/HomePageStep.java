package definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultPage;
import helpers.BrowserFactory;

import java.time.Duration;

public class HomePageStep {
    HomePage homePage = new HomePage();

    @Given("navigate to website")
    public void navigateToWebSite() {
        WebDriver driver = BrowserFactory.getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage.navigateToBiletHomePage("https://www.obilet.com/");
    }

    @Then("control {string} home page title")
    public void control_home_page_title(String homePageTitle) {
        homePage.controlHomePageTitle(homePageTitle);
    }

    @When("click on the member login button")
    public void click_on_the_member_login_button() {
        homePage.clickHomePageLoginButton();
    }

    @And("click on the sign up button")
    public void click_on_the_register_button() {
        homePage.clickLoginToRegisterButton();
    }

    @And("enter {string} and {string} and clicks on the register button")
    public void enter_mail_password_and_click_on_the_sign_up_button(String email, String password) {
        homePage.enterMailPasswordAndClickSignUpButton(email, password);
    }

    @Then("control the new user is successfully created")
    public void control_new_user_is_successfully_created() {
        homePage.controlSuccessfullyUserCreated();
    }

    @After
    public void quitDriver() {
        BrowserFactory.closeDriver();
    }

    @When("click on the flight tab")
    public void click_on_the_flight_tab() {
        homePage.clickFlightTab();
    }

    @And("select {string} departure city and {string} destination city")
    public void select_departure_and_destination_city(String departureCity, String destinationCity) {
        homePage.selectDepartureCityFlight(departureCity);
        homePage.selectDestinationCityFlight(destinationCity);
    }

    @And("select {string} departure date and {string} destination date")
    public void select_departure_and_destination_date(String departureDate, String destinationDate) {
        homePage.selectDepartureDate(homePage.dateMonthAndYear(departureDate), homePage.dateDay(departureDate));
        homePage.selectDestinationDate(homePage.dateMonthAndYear(destinationDate), homePage.dateDay(destinationDate));
    }

    @And("click on the search button")
    public SearchResultPage click_on_the_search_button() {
         homePage.clickSearchButton();
        return new SearchResultPage();
    }

    @Then("control the flight ticket search page is successfully opened")
    public void control_flight_ticket_search_page() {
        homePage.controlCurrentSearchFlightUrl();
    }
}
