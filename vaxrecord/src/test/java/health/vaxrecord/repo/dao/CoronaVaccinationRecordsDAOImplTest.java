package health.vaxrecord.repo.dao;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
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

class CoronaVaccinationRecordsDAOImplTest {

    private CoronaVaccinationRecordsDAO subject;

    @Test
    void getAll_success() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(H2)
                .addScript("classpath:db/migration/V1__Create_CoronaVaccinationRecord_Table.sql")
                .addScript("classpath:tests/test-insert-data.sql").build();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        subject = new CoronaVaccinationRecordsDAOImpl(jdbcTemplate);
        List<CoronaVaccinationRecordDTO> records = subject.getAll();

        assertThat(records.get(0).getCoronaVaccinationRecordId(), equalTo(1001));
        assertThat(records.get(0).getFirstName(), equalTo("testFirstName1"));
        assertThat(records.get(0).getLastName(), equalTo("testLastName1"));
        assertThat(records.get(0).getVaccineType(), equalTo("pfizer1"));
        assertThat(records.get(0).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-12-23 16:00:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        assertThat(records.get(0).getTimes(), equalTo(1));
        assertThat(records.get(0).getNote(), equalTo("ok"));
    }
}