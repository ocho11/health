package health.vaxrecord.repo;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.dto.NewCoronaVaccinationRecordDTO;

import java.util.List;

public interface CoronaVaccinationRecordsRepo {
    List<CoronaVaccinationRecordDTO> getAll();

    CoronaVaccinationRecordDTO getById(int coronaVaccinationRecordId);

    int create(NewCoronaVaccinationRecordDTO coronaVaccinationRecord);
}
