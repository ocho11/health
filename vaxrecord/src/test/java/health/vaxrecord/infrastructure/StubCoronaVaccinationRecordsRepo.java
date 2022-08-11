package health.vaxrecord.infrastructure;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class StubCoronaVaccinationRecordsRepo implements CoronaVaccinationRecordsRepo {

    final private CoronaVaccinationRecordDTO record1 = new CoronaVaccinationRecordDTO(1, "stubFirstName1",
            "stubLastName1",
            "pfizer1", LocalDateTime.of(2022, 8, 8, 8, 8, 8), 3, "no problem1");
    final private CoronaVaccinationRecordDTO record2 = new CoronaVaccinationRecordDTO(2,
            "stubFirstName2", "stubLastName2", "pfizer2", LocalDateTime.of(2022, 5, 5, 5, 5, 5), 2, "it's good2");
    final private List<CoronaVaccinationRecordDTO> records = asList(record1, record2);

    private CoronaVaccinationRecordDTO record;
    final private int newId = 5;

    @Override
    public List<CoronaVaccinationRecordDTO> getAll() {
        return records;
    }

    @Override
    public CoronaVaccinationRecordDTO getById(int coronaVaccinationRecordId) {
        for (CoronaVaccinationRecordDTO record:records
             ) {
            if(coronaVaccinationRecordId == record.getCoronaVaccinationRecordId()){
                this.record = record;
            }

        }
        return record;
    }

    @Override
    public int create(NewCoronaVaccinationRecordDTO coronaVaccinationRecord) {
        return newId;
    }
}