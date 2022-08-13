package health.vaxrecord.domain.repository;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;

import java.util.List;

public interface CoronaVaccinationRecordsRepo {
    List<CoronaVaccinationRecord> getAll();

    CoronaVaccinationRecord getById(int coronaVaccinationRecordId);

    int create(NewCoronaVaccinationRecord coronaVaccinationRecord);

    void delete(int coronaVaccinationRecordId);
}
