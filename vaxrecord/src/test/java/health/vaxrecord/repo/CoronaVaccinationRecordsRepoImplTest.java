package health.vaxrecord.repo;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.repo.dao.CoronaVaccinationRecordsDAO;
import health.vaxrecord.repo.dao.CoronaVaccinationRecordsDAOImpl;
import health.vaxrecord.repo.dao.StubCoronaVaccinationRecordsDAO;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

class CoronaVaccinationRecordsRepoImplTest {

    private CoronaVaccinationRecordsRepo subject;
    private CoronaVaccinationRecordsDAO stubCoronaVaccinationRecordsDAO;

    @Test
    void getAll() {
        stubCoronaVaccinationRecordsDAO = new StubCoronaVaccinationRecordsDAO();
        subject = new CoronaVaccinationRecordsRepoImpl(stubCoronaVaccinationRecordsDAO);

        List<CoronaVaccinationRecordDTO> records = subject.getAll();

        assertThat(records.size(), equalTo(2));
        assertThat(records.get(0).getCoronaVaccinationRecordId(), equalTo(1));
        assertThat(records.get(0).getFirstName(), equalTo("stubDTOFirstName1"));
        assertThat(records.get(0).getLastName(), equalTo("stubDTOLastName1"));
        assertThat(records.get(0).getVaccineType(), equalTo("stubDTOPfizer1"));
        assertThat(records.get(0).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-08-08 08:08:08",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(records.get(0).getTimes(), equalTo(2));
        assertThat(records.get(0).getNote(), equalTo("stubDTO no problem1"));
        assertThat(records.get(1).getCoronaVaccinationRecordId(), equalTo(2));
        assertThat(records.get(1).getFirstName(), equalTo("stubDTOFirstName2"));
        assertThat(records.get(1).getLastName(), equalTo("stubDTOLastName2"));
        assertThat(records.get(1).getVaccineType(), equalTo("stubDTOPfizer2"));
        assertThat(records.get(1).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-05-05 05:05:05",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(records.get(1).getTimes(), equalTo(3));
        assertThat(records.get(1).getNote(), equalTo("stubDTO no problem2"));
    }

    @Test
    void getById_success() {
        stubCoronaVaccinationRecordsDAO = new StubCoronaVaccinationRecordsDAO();
        subject = new CoronaVaccinationRecordsRepoImpl(stubCoronaVaccinationRecordsDAO);

        CoronaVaccinationRecordDTO record = subject.getById(2);

        assertThat(record.getCoronaVaccinationRecordId(), equalTo(2));
        assertThat(record.getFirstName(), equalTo("stubDTOFirstName2"));
        assertThat(record.getLastName(), equalTo("stubDTOLastName2"));
        assertThat(record.getVaccineType(), equalTo("stubDTOPfizer2"));
        assertThat(record.getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-05-05 05:05:05",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(record.getTimes(), equalTo(3));
        assertThat(record.getNote(), equalTo("stubDTO no problem2"));
    }
}