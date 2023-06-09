package com.zenika.training.bdd.stepdefs;


import com.zenika.training.bc_alerting.domain.intervention.Intervention;
import com.zenika.training.bc_alerting.domain.intervention.InterventionId;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.presentation.InterventionRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;

public class CreateInterventionStepDef {

    private String clinicId;
    private String carrierId;
    private String interventionId;
    private Response response;

    private String idSaved;


    @Autowired
    InterventionRepository interventionRepository;

    @Given("an intervention API")
    public void setupInterventionAPI() {
        RestAssured.baseURI = "http://localhost:8080";
        // Additional setup if needed
    }

    @When("a user creates an intervention with clinicId {string} and transpoteurID {string}")
    public void aUserCreatesAnInterventionWithClinicIdAndTranspoteurID(String clinicId, String transporteurID) {
        InterventionRequest request = new InterventionRequest(clinicId, transporteurID);
        response = given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/interventions");
    }

    @Then("the HTTP response is {int}")
    public void checkHttpResponse(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }


    @And("in the body we get an id")
    public void inTheBodyWeGetAn() {
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        idSaved = jsonPath.getString("id");
        Assert.assertNotNull(idSaved);

    }

    @And("the intervention with ID is saved in the database")
    public void theInterventionWithIDIsSavedInTheDatabase() {
        Intervention inter = interventionRepository.getIntervention(new InterventionId(idSaved));

        Assert.assertEquals(inter.getId().id, idSaved);

    }
}
