package health.vaxrecord.infrastructure.dao;


import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;
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
    public List<CoronaVaccinationRecord> getAll() {
        String sql = "SELECT * FROM corona_vaccination_record";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> new CoronaVaccinationRecord(
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
    public CoronaVaccinationRecord getById(int id) {
        String sql = "SELECT * FROM corona_vaccination_record WHERE corona_vaccination_record_id = ?";

        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> new CoronaVaccinationRecord(
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
    public int create(NewCoronaVaccinationRecord newCoronaVaccinationRecord) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into corona_vaccination_record (first_name, last_name, vaccine_type, vaccinated_date,  " +
                "times, note) " +
                "values (?, ?, ?, " +
                "?, ?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newCoronaVaccinationRecord.getFirstName());
            statement.setString(2, newCoronaVaccinationRecord.getLastName());
            statement.setString(3, newCoronaVaccinationRecord.getVaccineType());
            statement.setString(4, newCoronaVaccinationRecord.getVaccinatedDate().toString());
            statement.setInt(5, newCoronaVaccinationRecord.getTimes());
            statement.setString(6, newCoronaVaccinationRecord.getNote());
            return statement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean delete(int coronaVaccinationRecordId) {
        String sql = "delete from corona_vaccination_record where corona_vaccination_record_id = ?";
        int numberOfRowsEffected = jdbcTemplate.update(sql, coronaVaccinationRecordId);
        return numberOfRowsEffected != 0;
    }
}
