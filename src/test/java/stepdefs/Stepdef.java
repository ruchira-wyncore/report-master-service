package stepdefs;

import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Stepdef {
    private final String REST_API_URL = "http://localhost:8080";
    private final String ADD_ENDPOINT = "/api/report/master/add";
    private final String DELETE_ENDPOINT = "/api/report/master/delete/warehouse3";
    private final String UPDATE_SUCCESS_ENDPOINT = "/api/report/master/update/warehouse3";
    private final String UPDATE_FAILURE_ENDPOINT = "/api/report/master/update/warehouse4";
    private Boolean isAdded = false;
    private Boolean isDeleted = true;
    private Boolean isUpdated = true;
    private ReportMasterDTO reportMasterDTOResponse = new ReportMasterDTO();
    private ReportMasterDTO reportMasterDTO = new ReportMasterDTO();


    @Before
    public void init(){
        reportMasterDTO.setReportName("warehouse3");
        reportMasterDTO.setExecution("execution");
        reportMasterDTO.setServer("IBM");
        reportMasterDTO.setIntervalTime("08");
        reportMasterDTO.setStartTime("08:00:00");
        reportMasterDTO.setEndTime("09:00:00");
        reportMasterDTO.setIsInteractive("false");
    }

    @Given("^A running restful controller application$")
    public void a_running_restful_controller_application()  {
        //To Do Later
        // Check whether application is up and running.Add a health end point.
       // AssertTrue()
    }

    @When("^A post request is received to add a new valid record in the table$")
    public void a_post_request_is_received_to_add_a_new_valid_record_in_the_table() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = REST_API_URL+ADD_ENDPOINT;
        URI uri = new URI(baseUrl);



        ResponseEntity<ReportMasterDTO> result = restTemplate.postForEntity(uri, reportMasterDTO, ReportMasterDTO.class);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        if(result.getStatusCodeValue() == 200){
            isAdded = true;
        }
        reportMasterDTOResponse = result.getBody();
    }

    @Then("^the record is added$")
    public void the_record_is_added() {
        assertTrue(isAdded, "true");
    }

    @Then("^the record data is sent back$")
    public void the_record_data_is_sent_back()  {
        assertEquals("IBM", reportMasterDTOResponse.getServer());
        assertEquals("execution", reportMasterDTOResponse.getExecution());
        assertEquals("false", reportMasterDTOResponse.getIsInteractive());
        assertEquals("warehouse3", reportMasterDTOResponse.getReportName());
        assertEquals("08", reportMasterDTOResponse.getIntervalTime());
    }

    @When("^A delete request is received to delete an existing record in the table$")
    public void a_delete_request_is_received_to_delete_an_existing_record_in_the_table() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = REST_API_URL+DELETE_ENDPOINT;
        URI uri = new URI(baseUrl);
        try{
            restTemplate.delete(uri);
        }catch (RestClientException E){
            isDeleted = false;
        }
    }

    @Then("^the record is deleted$")
    public void the_record_is_deleted() {
        assertTrue(isDeleted, "true");
    }

    @When("^An update request is received to update an existing record in the table$")
    public void an_update_request_is_received_to_update_an_existing_record_in_the_table() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = REST_API_URL+UPDATE_SUCCESS_ENDPOINT;
        URI uri = new URI(baseUrl);
        reportMasterDTO.setServer("LINUX");
        try{
            restTemplate.put(uri, reportMasterDTO);
        }catch (RestClientException E){
            isUpdated = false;
        }
    }

    @When("^An update request is received to update a non existing record in the table$")
    public void an_update_request_is_received_to_update_a_non_existing_record_in_the_table() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = REST_API_URL+UPDATE_FAILURE_ENDPOINT;
        URI uri = new URI(baseUrl);
        reportMasterDTO.setServer("LINUX");
        try{
            restTemplate.put(uri, reportMasterDTO);
        }catch (RestClientException E){
            isUpdated = false;
        }

    }

    @Then("^the record is updated\\.$")
    public void the_record_is_updated() {
        assertTrue(isUpdated, "true");
    }

    @Then("^the record is not updated\\.$")
    public void the_record_is_not_updated()  {
        assertTrue(isUpdated, "false");
    }

}
