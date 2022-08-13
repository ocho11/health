package health.vaxrecord.infrastructure.dao;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;

import java.util.List;

public interface CoronaVaccinationRecordsDAO {
    List<CoronaVaccinationRecord> getAll();

    CoronaVaccinationRecord getById(int id);

    int create(NewCoronaVaccinationRecord newCoronaVaccinationRecordDTO);

    boolean delete(int coronaVaccinationRecordId);
}
