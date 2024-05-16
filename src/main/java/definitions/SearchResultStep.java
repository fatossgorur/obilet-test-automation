package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SearchResultPage;

public class SearchResultStep {
    SearchResultPage searchResultPage = new SearchResultPage();

    @And("select any {string} departure flight")
    public void select_any_departure_flight_with_flight_class(String flightClass) {
        searchResultPage.selectDepartureFlight();
        searchResultPage.selectDepartureFlightClass(flightClass);
    }

    @And("select any {string} return flight")
    public void select_any_return_flight_with_flight_class(String flightClass) {
        searchResultPage.selectReturnFlight();
        searchResultPage.selectReturnFlightClass(flightClass);
    }

    @Then("control multiple class for departure flight")
    public void control_multiple_class_for_departure_flight() {
        searchResultPage.controlDepartureFlightClass();
    }

    @Then("control multiple class for return flight")
    public void control_multiple_class_for_return_flight() {
        searchResultPage.controlReturnFlightClass();
    }

    @Then("control flight list")
    public void control_flight_list() {
        searchResultPage.controlFlightList();
    }

    @And("click discount code pop up")
    public void clickDiscountPopUp() {
        searchResultPage.closeDiscountPopUp();
    }
}
