package health.vaxrecord.repo;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;

import java.util.List;

public interface CoronaVaccinationRecordsRepo {
    List<CoronaVaccinationRecordDTO> getAll();

    CoronaVaccinationRecordDTO getById(int coronaVaccinationRecordId);
}
