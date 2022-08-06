package health.vaxrecord.controller;

import health.vaxrecord.repo.StubCoronaVaccinationRecordsRepo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class CoronaVaccinationRecordsControllerTest {
    private MockMvc coronaVaccinationRecordsController;
    private StubCoronaVaccinationRecordsRepo stubRepo;

    @Test
    public void getRecords_success() throws Exception {
        //Arrangement
        stubRepo = new StubCoronaVaccinationRecordsRepo();
        coronaVaccinationRecordsController = standaloneSetup(new CoronaVaccinationRecordsController(stubRepo)).build();
        //Act
        //Assertion
        coronaVaccinationRecordsController.perform(get("/coronarecords")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].coronaVaccinationRecordId", Matchers.equalTo(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.equalTo("stubFirstName1")))
                .andExpect(jsonPath("$[0].lastName", Matchers.equalTo("stubLastName1")))
                .andExpect(jsonPath("$[0].vaccineType", Matchers.equalTo("pfizer")))
                .andExpect(jsonPath("$[0].vaccinatedDate[0]", Matchers.equalTo(2022)))
                .andExpect(jsonPath("$[0].vaccinatedDate[1]", Matchers.equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[2]", Matchers.equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[3]", Matchers.equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[4]", Matchers.equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[5]", Matchers.equalTo(8)))
                .andExpect(jsonPath("$[0].times", Matchers.equalTo(3)))
                .andExpect(jsonPath("$[0].note", Matchers.equalTo("no problem")))
                .andExpect(jsonPath("$[1].coronaVaccinationRecordId", Matchers.equalTo(2)))
                .andExpect(jsonPath("$[1].firstName", Matchers.equalTo("stubFirstName2")))
                .andExpect(jsonPath("$[1].lastName", Matchers.equalTo("stubLastName2")))
                .andExpect(jsonPath("$[1].vaccineType", Matchers.equalTo("pfizer")))
                .andExpect(jsonPath("$[1].vaccinatedDate[0]", Matchers.equalTo(2022)))
                .andExpect(jsonPath("$[1].vaccinatedDate[1]", Matchers.equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[2]", Matchers.equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[3]", Matchers.equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[4]", Matchers.equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[5]", Matchers.equalTo(5)))
                .andExpect(jsonPath("$[1].times", Matchers.equalTo(2)))
                .andExpect(jsonPath("$[1].note", Matchers.equalTo("it's good")));
    }

}