package health.vaxrecord.repo;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.dto.NewCoronaVaccinationRecordDTO;

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
        return 5;
    }
}
