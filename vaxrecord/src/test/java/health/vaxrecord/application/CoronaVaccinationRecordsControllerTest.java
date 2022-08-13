package health.vaxrecord.application;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @Nested
    class GetAll_NoParameter {
        @Test
        public void wasCalled_from_CoronaVaccinationRecordsRepo() throws Exception {
            subject.perform(get("/coronarecords")
                    .accept(MediaType.APPLICATION_JSON));

            verify(coronaVaccinationRecordsRepo, times(1))
                    .getAll();
        }

        @Test
        public void does_theResponseCode_200() throws Exception {
            subject.perform(get("/coronarecords")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void does_theOneResponse_sameTheExpectation() throws Exception {
            doReturn(
                    Collections.singletonList(
                            new CoronaVaccinationRecord(111, "firstName111", "lastName111", "pfizer111",
                                    LocalDateTime.of(2022, 5, 5, 5, 5), 111, "no problem 111")
                    )
            )
                    .when(coronaVaccinationRecordsRepo).getAll();

            subject.perform(get("/coronarecords")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].coronaVaccinationRecordId", equalTo(111)))
                    .andExpect(jsonPath("$[0].firstName", equalTo("firstName111")))
                    .andExpect(jsonPath("$[0].lastName", equalTo("lastName111")))
                    .andExpect(jsonPath("$[0].vaccineType", equalTo("pfizer111")))
                    .andExpect(jsonPath("$[0].times", equalTo(111)))
                    .andExpect(jsonPath("$[0].note", equalTo("no problem 111")));
        }

        @Test
        public void does_theAllResponse_sameTheExpectation() throws Exception {
            doReturn(
                    List.of(
                            new CoronaVaccinationRecord(111, "firstName111", "lastName111", "pfizer111",
                                    LocalDateTime.of(2022, 5, 5, 5, 5), 111, "no problem 111"),
                            new CoronaVaccinationRecord(222, "firstName222", "lastName222", "pfizer222",
                                    LocalDateTime.of(2022, 5, 5, 5, 5), 222, "no problem 222")
                    )
            )
                    .when(coronaVaccinationRecordsRepo).getAll();

            subject.perform(get("/coronarecords")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].coronaVaccinationRecordId", equalTo(111)))
                    .andExpect(jsonPath("$[0].firstName", equalTo("firstName111")))
                    .andExpect(jsonPath("$[0].lastName", equalTo("lastName111")))
                    .andExpect(jsonPath("$[0].vaccineType", equalTo("pfizer111")))
                    .andExpect(jsonPath("$[0].times", equalTo(111)))
                    .andExpect(jsonPath("$[0].note", equalTo("no problem 111")))
                    .andExpect(jsonPath("$[1].coronaVaccinationRecordId", equalTo(222)))
                    .andExpect(jsonPath("$[1].firstName", equalTo("firstName222")))
                    .andExpect(jsonPath("$[1].lastName", equalTo("lastName222")))
                    .andExpect(jsonPath("$[1].vaccineType", equalTo("pfizer222")))
                    .andExpect(jsonPath("$[1].times", equalTo(222)))
                    .andExpect(jsonPath("$[1].note", equalTo("no problem 222")));
        }
    }

    @Nested
    class GetById_CoronaVaccinationRecordId {
        @Test
        public void wasCalled_from_CoronaVaccinationRecordsRepo() throws Exception {
            doReturn(new CoronaVaccinationRecord(
                    2,
                    "firstName2",
                    "lastName2",
                    "pfizer2",
                    LocalDate.of(2022, 5, 5).atTime(5, 5),
                    2,
                    "no problem12")).when(coronaVaccinationRecordsRepo).getById(anyInt());

            subject.perform(get("/coronarecords/2")
                    .accept(MediaType.APPLICATION_JSON));

            verify(coronaVaccinationRecordsRepo, times(1))
                    .getById(anyInt());
        }

        @Test
        public void does_theResponseCode_200() throws Exception {
            doReturn(new CoronaVaccinationRecord(
                    2,
                    "firstName2",
                    "lastName2",
                    "pfizer2",
                    LocalDate.of(2022, 5, 5).atTime(5, 5),
                    2,
                    "no problem12")).when(coronaVaccinationRecordsRepo).getById(anyInt());

            subject.perform(get("/coronarecords/2")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void does_theResponse_sameTheExpectation() throws Exception {
            doReturn(
                    new CoronaVaccinationRecord(
                            2,
                            "firstName2",
                            "lastName2",
                            "pfizer2",
                            LocalDate.of(2022, 5, 5).atTime(5, 5),
                            2,
                            "no problem12")
            )
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
    }

    @Nested
    class CreateRecord_NewCoronaVaccinationRecordDTO {
        @Test
        public void wasCalled_from_CoronaVaccinationRecordsRepo() throws Exception {
            subject.perform(post("/coronarecords")
                    .content("{\n" +
                            "  \"firstName\": \"firstName5\",\n" +
                            "  \"lastName\": \"lastName5\",\n" +
                            "  \"vaccineType\": \"pfizer5\",\n" +
                            "  \"vaccinatedDate\": \"2022-03-04T11:30\",\n" +
                            "  \"times\": 3,\n" +
                            "  \"note\": \"Ok\"\n" +
                            "}")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));

            verify(coronaVaccinationRecordsRepo, times(1))
                    .create(any());
        }

        @Test
        public void does_theResponseCode_201() throws Exception {
            subject.perform(post("/coronarecords")
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
                    .andExpect(status().isCreated());
        }

        @Test
        public void does_theResponse_sameTheExpectation() throws Exception {
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

    @Nested
    class DeleteRecord_RecordId {
        @Test
        public void wasCalled_from_CoronaVaccinationRecordsRepo() throws Exception {
            subject.perform(delete("/coronarecords/2"))
                    .andReturn();

            verify(coronaVaccinationRecordsRepo,times(1)).delete(anyInt());
        }

        @Test
        public void does_theResponseCode_204() throws Exception {
            subject.perform(delete("/coronarecords/2"))
                    .andExpect(status().isNoContent());
        }
    }


}