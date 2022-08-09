package health.vaxrecord.repo.dao;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class CoronaVaccinationRecordsDAOImpl implements CoronaVaccinationRecordsDAO {

    private JdbcTemplate jdbcTemplate;

    public CoronaVaccinationRecordsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CoronaVaccinationRecordDTO> getAll() {
        String sql = "SELECT * FROM corona_vaccination_record;";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> new CoronaVaccinationRecordDTO(
                resultSet.getInt("corona_vaccination_record_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("vaccine_type"),
                LocalDateTime.parse(resultSet.getString("vaccinated_date"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                resultSet.getInt("times"),
                resultSet.getString("note")
        ));
    }
}
