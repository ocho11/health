package health.vaxrecord.infrastructure.dao;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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

    @BeforeEach
    void setUp() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(H2)
                .addScript("classpath:db/migration/V1__Create_CoronaVaccinationRecord_Table.sql")
                .addScript("classpath:tests/test-insert-data.sql").build();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        subject = new CoronaVaccinationRecordsDAOImpl(jdbcTemplate);
    }

    @Nested
    class GetAll_NoParameter {
        @Test
        void returned_theListOf_CoronaVaccinationRecord() {
            List<CoronaVaccinationRecord> records = subject.getAll();

            assertThat(records.size(), equalTo(3));
            assertThat(records.get(0).getCoronaVaccinationRecordId(), equalTo(1001));
            assertThat(records.get(0).getFirstName(), equalTo("testFirstName1"));
            assertThat(records.get(0).getLastName(), equalTo("testLastName1"));
            assertThat(records.get(0).getVaccineType(), equalTo("pfizer1"));
            assertThat(records.get(0).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-12-23 16:00:00",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            assertThat(records.get(0).getTimes(), equalTo(1));
            assertThat(records.get(0).getNote(), equalTo("ok"));
            assertThat(records.get(1).getCoronaVaccinationRecordId(), equalTo(1002));
            assertThat(records.get(1).getFirstName(), equalTo("testFirstName2"));
            assertThat(records.get(1).getLastName(), equalTo("testLastName2"));
            assertThat(records.get(1).getVaccineType(), equalTo("pfizer2"));
            assertThat(records.get(1).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-05-23 16:00:00",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            assertThat(records.get(1).getTimes(), equalTo(2));
            assertThat(records.get(1).getNote(), equalTo("not ok"));
            assertThat(records.get(2).getCoronaVaccinationRecordId(), equalTo(1003));
            assertThat(records.get(2).getFirstName(), equalTo("testFirstName3"));
            assertThat(records.get(2).getLastName(), equalTo("testLastName3"));
            assertThat(records.get(2).getVaccineType(), equalTo("pfizer3"));
            assertThat(records.get(2).getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-03-23 16:00:00",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            assertThat(records.get(2).getTimes(), equalTo(3));
            assertThat(records.get(2).getNote(), equalTo("no problem"));
        }
    }

    @Nested
    class GetById_CoronaVaccinationRecordId {
        @Test
        public void returned_theCoronaRecord_byId() {
            CoronaVaccinationRecord record = subject.getById(1002);

            assertThat(record.getCoronaVaccinationRecordId(), equalTo(1002));
            assertThat(record.getFirstName(), equalTo("testFirstName2"));
            assertThat(record.getLastName(), equalTo("testLastName2"));
            assertThat(record.getVaccineType(), equalTo("pfizer2"));
            assertThat(record.getVaccinatedDate(), equalTo(LocalDateTime.parse("2022-05-23 16:00:00",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            assertThat(record.getTimes(), equalTo(2));
            assertThat(record.getNote(), equalTo("not ok"));
        }
    }

    @Nested
    class Create_NewCoronaVaccinationRecord {
        @Test
        public void returned_theId_and_Created_theCoronaRecord() {
            NewCoronaVaccinationRecord newCoronaVaccinationRecord = new NewCoronaVaccinationRecord("newFirstName",
                    "newOLastName", "newPfizer",
                    LocalDateTime.of(2022, 5, 5, 5, 5, 5), 2, "new no problem1");

            int newId = subject.create(newCoronaVaccinationRecord);

            assertThat(newId, equalTo(1));
        }
    }

    @Nested
    class DeleteRecord_RecordId {
        @Test
        public void returned_true_byId() {
            boolean response = subject.delete(1003);

            assertThat(response, equalTo(true));
        }
    }
}