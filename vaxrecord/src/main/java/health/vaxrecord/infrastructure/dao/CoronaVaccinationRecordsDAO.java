package health.vaxrecord.infrastructure.dao;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;

import java.util.List;

public interface CoronaVaccinationRecordsDAO {
    public List<CoronaVaccinationRecord> getAll();

    public CoronaVaccinationRecord getById(int id);

    public int create(NewCoronaVaccinationRecord newCoronaVaccinationRecordDTO);
}
