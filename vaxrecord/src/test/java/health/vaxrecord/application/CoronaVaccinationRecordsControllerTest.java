package health.vaxrecord.application;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class CoronaVaccinationRecordsControllerTest {
    private MockMvc subject;

    @Mock
    private CoronaVaccinationRecordsRepo coronaVaccinationRecordsRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subject = standaloneSetup(new CoronaVaccinationRecordsController(coronaVaccinationRecordsRepo)).build();
    }

    @Test
    public void getRecords_success() throws Exception {
        subject.perform(get("/coronarecords")
                .accept(MediaType.APPLICATION_JSON));

        verify(coronaVaccinationRecordsRepo, times(1))
                .getAll();
    }

    @Test
    public void getById_success() throws Exception {
        CoronaVaccinationRecord coronaVaccinationRecord = new CoronaVaccinationRecord(
                2,
                "firstName2",
                "lastName2",
                "pfizer2",
                LocalDate.of(2022, 5, 5).atTime(5, 5),
                2,
                "no problem12");
        System.out.printf(coronaVaccinationRecord.toString());

        doReturn(
                coronaVaccinationRecord)
                .when(coronaVaccinationRecordsRepo).getById(2);

        subject.perform(get("/coronarecords/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coronaVaccinationRecordId", equalTo(2)))
                .andExpect(jsonPath("$.firstName", equalTo("firstName2")))
                .andExpect(jsonPath("$.lastName", equalTo("lastName2")))
                .andExpect(jsonPath("$.vaccineType", equalTo("pfizer2")))
                .andExpect(jsonPath("$.times", equalTo(2)))
                .andExpect(jsonPath("$.note", equalTo("no problem12")));
    }

    @Test
    public void createRecord_success() throws Exception {
        doReturn(5)
                .when(coronaVaccinationRecordsRepo).create(any());

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