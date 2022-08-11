package health.vaxrecord.repo.dao;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.dto.NewCoronaVaccinationRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class CoronaVaccinationRecordsDAOImpl implements CoronaVaccinationRecordsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CoronaVaccinationRecordsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CoronaVaccinationRecordDTO> getAll() {
        String sql = "SELECT * FROM corona_vaccination_record";

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

    @Override
    public CoronaVaccinationRecordDTO getById(int id) {
        String sql = "SELECT * FROM corona_vaccination_record WHERE corona_vaccination_record_id = ?";

        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> new CoronaVaccinationRecordDTO(
                        resultSet.getInt("corona_vaccination_record_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("vaccine_type"),
                        LocalDateTime.parse(resultSet.getString("vaccinated_date"),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                        resultSet.getInt("times"),
                        resultSet.getString("note"))
                , id);
    }

    @Override
    public int create(NewCoronaVaccinationRecordDTO newCoronaVaccinationRecordDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into corona_vaccination_record (first_name, last_name, vaccine_type, vaccinated_date,  " +
                "times, note) " +
                "values (?, ?, ?, " +
                "?, ?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newCoronaVaccinationRecordDTO.getFirstName());
            statement.setString(2, newCoronaVaccinationRecordDTO.getLastName());
            statement.setString(3, newCoronaVaccinationRecordDTO.getVaccineType());
            statement.setString(4, newCoronaVaccinationRecordDTO.getVaccinatedDate().toString());
            statement.setInt(5, newCoronaVaccinationRecordDTO.getTimes());
            statement.setString(6, newCoronaVaccinationRecordDTO.getNote());
            return statement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
}
