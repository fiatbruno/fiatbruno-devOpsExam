package rw.ac.rca.devOpsExam.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import rw.ac.rca.devOpsExam.domain.Calculator;
import rw.ac.rca.devOpsExam.utils.APIResponse;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String apiPath = "/api/calculator";

    @Test
    public void getById_success() throws JSONException {
        ResponseEntity<Calculator> Calculator = this.restTemplate.getForEntity(apiPath+"/id/101",Calculator.class);

        assertTrue(calculator.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void getById_404() throws JSONException {
        ResponseEntity<APIResponse> response = this.restTemplate.getForEntity(apiPath+"/id/600",APIResponse.class);

        assertTrue(response.getStatusCodeValue()==404);
        assertFalse(response.getBody().isStatus());
        assertEquals("Calculator not found",response.getBody().getMessage());

    }

    @Test
    public void postCalculator_success() throws JSONException {
        Calculator body = new Calculator(100L);
        ResponseEntity<Calculator> item = this.restTemplate.postForEntity(apiPath+"/add",body, Calculator.class);

        assertTrue(item.getStatusCode().is2xxSuccessful());
        assertEquals(100,item.getBody().getId());

    }

    @Test
    public void postCalculator_404() throws JSONException {
        Calculator body = new Calculator(101L);
        ResponseEntity<APIResponse> response = this.restTemplate.postForEntity(apiPath+"/add",body,APIResponse.class);

        assertTrue(response.getStatusCodeValue()==400);
        assertFalse(response.getBody().isStatus());
        assertEquals("Calculator with id ... is registered already",response.getBody().getMessage());

    }

}
