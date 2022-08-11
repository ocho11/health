package health.vaxrecord.infrastructure;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import health.vaxrecord.infrastructure.dao.CoronaVaccinationRecordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoronaVaccinationRecordsRepoImpl implements CoronaVaccinationRecordsRepo {

    @Autowired
    private CoronaVaccinationRecordsDAO coronaVaccinationRecordsDAO;

    public CoronaVaccinationRecordsRepoImpl(CoronaVaccinationRecordsDAO coronaVaccinationRecordsDAO) {
        this.coronaVaccinationRecordsDAO = coronaVaccinationRecordsDAO;
    }

    @Override
    public List<CoronaVaccinationRecordDTO> getAll() {
        return coronaVaccinationRecordsDAO.getAll();
    }

    @Override
    public CoronaVaccinationRecordDTO getById(int coronaVaccinationRecordId) {
        return coronaVaccinationRecordsDAO.getById(coronaVaccinationRecordId);
    }

    @Override
    public int create(NewCoronaVaccinationRecordDTO coronaVaccinationRecord) {
        return coronaVaccinationRecordsDAO.create(coronaVaccinationRecord);
    }
}
