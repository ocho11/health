package health.vaxrecord.repo.dao;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;

import java.util.List;

public interface CoronaVaccinationRecordsDAO {
    public List<CoronaVaccinationRecordDTO> getAll();

    public CoronaVaccinationRecordDTO getById(int id);
}
