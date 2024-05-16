package definitions;

import io.cucumber.java.en.And;
import pages.PaymentPage;

public class PaymentPageStep {

    PaymentPage paymentPage = new PaymentPage();

    @And("control the payment page is successfully opened")
    public void control_redirect_payment_page() {
        paymentPage.controlCurrentPaymentUrl();
    }

    @And("control {string} departure and {string} return flights on the payment page")
    public void control_flights_on_the_payment_page(String originCity,String destinationCity) {
        paymentPage.controlDepartureFlights(originCity,destinationCity);
        paymentPage.controlReturnFlights(originCity,destinationCity);
    }
}
