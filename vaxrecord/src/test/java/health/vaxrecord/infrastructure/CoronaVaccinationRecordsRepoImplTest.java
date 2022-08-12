package health.vaxrecord.infrastructure;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import health.vaxrecord.infrastructure.dao.CoronaVaccinationRecordsDAO;
import health.vaxrecord.infrastructure.dao.CoronaVaccinationRecordsDAOImpl;
import health.vaxrecord.infrastructure.dao.StubCoronaVaccinationRecordsDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class CoronaVaccinationRecordsRepoImplTest {

    private CoronaVaccinationRecordsRepo subject;

    @Mock
    private CoronaVaccinationRecordsDAO coronaVaccinationRecordsDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subject = new CoronaVaccinationRecordsRepoImpl(coronaVaccinationRecordsDAO);
    }

    @Nested
    class GetAll_NoParameter {
        @Test
        void wasCalled_from_CoronaVaccinationRecordsDAO() {
            subject.getAll();

            verify(coronaVaccinationRecordsDAO, times(1))
                    .getAll();

        }

        @Test
        void does_theOneResponse_sameTheExpectation() {
            doReturn(
                    List.of(
                            new CoronaVaccinationRecord(101, "firstName101", "lastName101", "pfizer101",
                                    LocalDateTime.of(2022, 5, 5, 5, 5), 101, "no problem 101")
                    )
            ).when(coronaVaccinationRecordsDAO).getAll();

            List<CoronaVaccinationRecord> response = subject.getAll();

            assertThat(response.get(0).getCoronaVaccinationRecordId(), equalTo(101));
            assertThat(response.get(0).getFirstName(), equalTo("firstName101"));
            assertThat(response.get(0).getLastName(), equalTo("lastName101"));
            assertThat(response.get(0).getVaccineType(), equalTo("pfizer101"));
            assertThat(response.get(0).getTimes(), equalTo(101));
            assertThat(response.get(0).getNote(), equalTo("no problem 101"));
        }

        @Test
        void does_theAllResponse_sameTheExpectation() {
            doReturn(
                    List.of(
                            new CoronaVaccinationRecord(111, "firstName111", "lastName111", "pfizer111",
                                    LocalDateTime.of(2022, 5, 5, 5, 5), 111, "no problem 111"),
                            new CoronaVaccinationRecord(222, "firstName222", "lastName222", "pfizer222",
                                    LocalDateTime.of(2022, 5, 5, 5, 5), 222, "no problem 222")
                    )
            ).when(coronaVaccinationRecordsDAO).getAll();

            List<CoronaVaccinationRecord> response = coronaVaccinationRecordsDAO.getAll();

            assertThat(response.get(0).getCoronaVaccinationRecordId(), equalTo(111));
            assertThat(response.get(0).getFirstName(), equalTo("firstName111"));
            assertThat(response.get(0).getLastName(), equalTo("lastName111"));
            assertThat(response.get(0).getVaccineType(), equalTo("pfizer111"));
            assertThat(response.get(0).getTimes(), equalTo(111));
            assertThat(response.get(0).getNote(), equalTo("no problem 111"));
            assertThat(response.get(1).getCoronaVaccinationRecordId(), equalTo(222));
            assertThat(response.get(1).getFirstName(), equalTo("firstName222"));
            assertThat(response.get(1).getLastName(), equalTo("lastName222"));
            assertThat(response.get(1).getVaccineType(), equalTo("pfizer222"));
            assertThat(response.get(1).getTimes(), equalTo(222));
            assertThat(response.get(1).getNote(), equalTo("no problem 222"));
        }
    }

    @Nested
    class GetById_CoronaVaccinationRecordId {
        @Test
        void wasCalled_from_CoronaVaccinationRecordsDAO() {
            subject.getById(anyInt());

            verify(coronaVaccinationRecordsDAO, times(1)).getById(anyInt());
        }

        @Test
        void does_theResponse_sameTheExpectation() {
            doReturn(
                    new CoronaVaccinationRecord(222, "firstName222", "lastName222", "pfizer222",
                            LocalDateTime.of(2022, 5, 5, 5, 5), 222, "no problem 222")
            ).when(coronaVaccinationRecordsDAO).getById(222);

            CoronaVaccinationRecord response = subject.getById(222);

            assertThat(response.getCoronaVaccinationRecordId(), equalTo(222));
            assertThat(response.getFirstName(), equalTo("firstName222"));
            assertThat(response.getLastName(), equalTo("lastName222"));
            assertThat(response.getVaccineType(), equalTo("pfizer222"));
            assertThat(response.getTimes(), equalTo(222));
            assertThat(response.getNote(), equalTo("no problem 222"));

        }
    }

    @Nested
    class Create_NewCoronaVaccinationRecord {
        @Test
        void wasCalled_from_CoronaVaccinationRecordsDAO() {
            NewCoronaVaccinationRecord newCoronaVaccinationRecord = new NewCoronaVaccinationRecord( "newFirstName101",
                    "newLastName101", "newPfizer101",
                    LocalDateTime.of(2022, 5, 5, 5, 5), 101, "new problem 101");
            subject.create(newCoronaVaccinationRecord);

            verify(coronaVaccinationRecordsDAO,times(1)).create(newCoronaVaccinationRecord);
        }

        @Test
        void does_theResponse_sameTheExpectation(){
            NewCoronaVaccinationRecord newCoronaVaccinationRecord = new NewCoronaVaccinationRecord( "newFirstName101",
                    "newLastName101", "newPfizer101",
                    LocalDateTime.of(2022, 5, 5, 5, 5), 101, "new problem 101");
            doReturn(101)
                    .when(coronaVaccinationRecordsDAO).create(newCoronaVaccinationRecord);

            int response = subject.create(newCoronaVaccinationRecord);

            assertThat(response,equalTo(101));
        }
    }
}