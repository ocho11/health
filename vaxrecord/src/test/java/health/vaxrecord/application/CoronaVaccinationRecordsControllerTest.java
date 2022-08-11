package health.vaxrecord.application;

import health.vaxrecord.infrastructure.StubCoronaVaccinationRecordsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class CoronaVaccinationRecordsControllerTest {
    private MockMvc subject;
    private StubCoronaVaccinationRecordsRepo stubRepo;

    @BeforeEach
    void setUp() {
        stubRepo = new StubCoronaVaccinationRecordsRepo();
        subject = standaloneSetup(new CoronaVaccinationRecordsController(stubRepo)).build();
    }

    @Test
    public void getRecords_success() throws Exception {
        subject.perform(get("/coronarecords")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].coronaVaccinationRecordId", equalTo(1)))
                .andExpect(jsonPath("$[0].firstName", equalTo("stubFirstName1")))
                .andExpect(jsonPath("$[0].lastName", equalTo("stubLastName1")))
                .andExpect(jsonPath("$[0].vaccineType", equalTo("pfizer1")))
                .andExpect(jsonPath("$[0].vaccinatedDate[0]", equalTo(2022)))
                .andExpect(jsonPath("$[0].vaccinatedDate[1]", equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[2]", equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[3]", equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[4]", equalTo(8)))
                .andExpect(jsonPath("$[0].vaccinatedDate[5]", equalTo(8)))
                .andExpect(jsonPath("$[0].times", equalTo(3)))
                .andExpect(jsonPath("$[0].note", equalTo("no problem1")))
                .andExpect(jsonPath("$[1].coronaVaccinationRecordId", equalTo(2)))
                .andExpect(jsonPath("$[1].firstName", equalTo("stubFirstName2")))
                .andExpect(jsonPath("$[1].lastName", equalTo("stubLastName2")))
                .andExpect(jsonPath("$[1].vaccineType", equalTo("pfizer2")))
                .andExpect(jsonPath("$[1].vaccinatedDate[0]", equalTo(2022)))
                .andExpect(jsonPath("$[1].vaccinatedDate[1]", equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[2]", equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[3]", equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[4]", equalTo(5)))
                .andExpect(jsonPath("$[1].vaccinatedDate[5]", equalTo(5)))
                .andExpect(jsonPath("$[1].times", equalTo(2)))
                .andExpect(jsonPath("$[1].note", equalTo("it's good2")));
    }

    @Test
    public void getById_success() throws Exception {
        subject.perform(get("/coronarecords/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coronaVaccinationRecordId", equalTo(2)))
                .andExpect(jsonPath("$.firstName", equalTo("stubFirstName2")))
                .andExpect(jsonPath("$.lastName", equalTo("stubLastName2")))
                .andExpect(jsonPath("$.vaccineType", equalTo("pfizer2")))
                .andExpect(jsonPath("$.vaccinatedDate[0]", equalTo(2022)))
                .andExpect(jsonPath("$.vaccinatedDate[1]", equalTo(5)))
                .andExpect(jsonPath("$.vaccinatedDate[2]", equalTo(5)))
                .andExpect(jsonPath("$.vaccinatedDate[3]", equalTo(5)))
                .andExpect(jsonPath("$.vaccinatedDate[4]", equalTo(5)))
                .andExpect(jsonPath("$.vaccinatedDate[5]", equalTo(5)))
                .andExpect(jsonPath("$.times", equalTo(2)))
                .andExpect(jsonPath("$.note", equalTo("it's good2")));
    }

    @Test
    public void createRecord_success() throws Exception {
        MockHttpServletResponse response = subject.perform(post("/coronarecords")
                        .content("{\n" +
                                "  \"firstName\": \"firstName5\",\n" +
                                "  \"lastName\": \"lastName5\",\n" +
                                "  \"vaccineType\": \"pfizer5\",\n" +
                                "  \"vaccinatedDate\": \"2022-03-04T11:30\",\n" +
                                "  \"times\": 3,\n" +
                                "  \"note\": \"Ok\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus(), equalTo(CREATED.value()));
        assertThat(response.getContentAsString(), equalTo("{" +
                "\"id\":5" +
                "}"));
    }
}