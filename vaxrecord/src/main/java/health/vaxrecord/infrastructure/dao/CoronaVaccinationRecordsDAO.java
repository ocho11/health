package health.vaxrecord.infrastructure.dao;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;

import java.util.List;

public interface CoronaVaccinationRecordsDAO {
    public List<CoronaVaccinationRecordDTO> getAll();

    public CoronaVaccinationRecordDTO getById(int id);

    public int create(NewCoronaVaccinationRecordDTO newCoronaVaccinationRecordDTO);
}
