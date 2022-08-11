package health.vaxrecord.domain.repository;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;

import java.util.List;

public interface CoronaVaccinationRecordsRepo {
    List<CoronaVaccinationRecordDTO> getAll();

    CoronaVaccinationRecordDTO getById(int coronaVaccinationRecordId);

    int create(NewCoronaVaccinationRecordDTO coronaVaccinationRecord);
}
