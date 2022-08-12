package health.vaxrecord.infrastructure;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import health.vaxrecord.infrastructure.dao.CoronaVaccinationRecordsDAO;
import health.vaxrecord.infrastructure.dao.StubCoronaVaccinationRecordsDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CoronaVaccinationRecordsRepoImplTest {

    private CoronaVaccinationRecordsRepo subject;
    private CoronaVaccinationRecordsDAO stubCoronaVaccinationRecordsDAO;

    @BeforeEach
    void setUp() {
        stubCoronaVaccinationRecordsDAO = new StubCoronaVaccinationRecordsDAO();
        subject = new CoronaVaccinationRecordsRepoImpl(stubCoronaVaccinationRecordsDAO);
    }

    @Test
    void getAll() {
        List<CoronaVaccinationRecord> records = subject.getAll();

        assertThat(records.size(), equalTo(2));
        assertThat(records.get(0).getCoronaVaccinationRecordId(), equalTo(1));
        assertThat(records.get(0).getFirstName(), equalTo("stubFirstName1"));
        assertThat(records.get(0).getLastName(), equalTo("stubLastName1"));
        assertThat(records.get(0).getVaccineType(), equalTo("stubPfizer1"));
        assertThat(records.get(0).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-08-08 08:08:08",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(records.get(0).getTimes(), equalTo(2));
        assertThat(records.get(0).getNote(), equalTo("stub no problem1"));
        assertThat(records.get(1).getCoronaVaccinationRecordId(), equalTo(2));
        assertThat(records.get(1).getFirstName(), equalTo("stubFirstName2"));
        assertThat(records.get(1).getLastName(), equalTo("stubLastName2"));
        assertThat(records.get(1).getVaccineType(), equalTo("stubPfizer2"));
        assertThat(records.get(1).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-05-05 05:05:05",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(records.get(1).getTimes(), equalTo(3));
        assertThat(records.get(1).getNote(), equalTo("stub no problem2"));
    }

    @Test
    void getById_success() {
        CoronaVaccinationRecord record = subject.getById(2);

        assertThat(record.getCoronaVaccinationRecordId(), equalTo(2));
        assertThat(record.getFirstName(), equalTo("stubFirstName2"));
        assertThat(record.getLastName(), equalTo("stubLastName2"));
        assertThat(record.getVaccineType(), equalTo("stubPfizer2"));
        assertThat(record.getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-05-05 05:05:05",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(record.getTimes(), equalTo(3));
        assertThat(record.getNote(), equalTo("stub no problem2"));
    }

    @Test
    void create_success(){
        NewCoronaVaccinationRecord newCoronaVaccinationRecord = new NewCoronaVaccinationRecord("newFirstName",
                "newOLastName", "newPfizer",
                LocalDateTime.of(2022, 5, 5, 5, 5, 5), 2, "new no problem1");

        int newId = subject.create(newCoronaVaccinationRecord);

        assertThat(newId, equalTo(3));
    }
}