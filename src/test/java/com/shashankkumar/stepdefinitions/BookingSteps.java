package com.shashankkumar.stepdefinitions;

import com.shashankkumar.enums.APIResources;
import com.shashankkumar.utils.ExcelUtils;
import com.shashankkumar.utils.ScenarioContext;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class BookingSteps {

    private Response response;
    private String firstname;

    @Given("User has booking data from {string} sheet {string} row {int}")
    public void user_has_booking_data(String file, String sheet, int row) throws Exception {
        firstname = ExcelUtils.getCellData(file, sheet, row, 0);
        String lastname = ExcelUtils.getCellData(file, sheet, row, 1);
        String totalPrice = ExcelUtils.getCellData(file, sheet, row, 2);
        String depositPaid = ExcelUtils.getCellData(file, sheet, row, 3);
        String checkin = ExcelUtils.getCellData(file, sheet, row, 4);
        String checkout = ExcelUtils.getCellData(file, sheet, row, 5);

        String body = "{\n" +
                "  \"firstname\":\"" + firstname + "\",\n" +
                "  \"lastname\":\"" + lastname + "\",\n" +
                "  \"totalprice\":" + totalPrice + ",\n" +
                "  \"depositpaid\":" + depositPaid + ",\n" +
                "  \"bookingdates\":{\"checkin\":\"" + checkin + "\",\"checkout\":\"" + checkout + "\"}\n" +
                "}";

        ScenarioContext.getRestHelper().initRequest("https://restful-booker.herokuapp.com");
        ScenarioContext.getRestHelper().setBody(body);
    }

    @When("User calls {string} API with {string} request")
    public void user_calls_api(String resourceName, String method) {
        APIResources resource = APIResources.valueOf(resourceName);
        if (method.equalsIgnoreCase("POST")) response = ScenarioContext.getRestHelper().post(resource.getResource());
        else if (method.equalsIgnoreCase("GET")) response = ScenarioContext.getRestHelper().get(resource.getResource());
    }

    @Then("API call is successful with status code {int}")
    public void api_call_successful(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("Verify booking firstname is {string}")
    public void verify_booking_firstname(String expected) {
        response.then().body("booking.firstname", equalTo(expected));
    }
}
