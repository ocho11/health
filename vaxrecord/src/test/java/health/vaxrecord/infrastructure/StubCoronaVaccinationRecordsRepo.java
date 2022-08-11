package health.vaxrecord.infrastructure;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class StubCoronaVaccinationRecordsRepo implements CoronaVaccinationRecordsRepo {

    final private CoronaVaccinationRecord record1 = new CoronaVaccinationRecord(1, "stubFirstName1",
            "stubLastName1",
            "pfizer1", LocalDateTime.of(2022, 8, 8, 8, 8, 8), 3, "no problem1");
    final private CoronaVaccinationRecord record2 = new CoronaVaccinationRecord(2,
            "stubFirstName2", "stubLastName2", "pfizer2", LocalDateTime.of(2022, 5, 5, 5, 5, 5), 2, "it's good2");
    final private List<CoronaVaccinationRecord> records = asList(record1, record2);

    private CoronaVaccinationRecord record;
    final private int newId = 5;

    @Override
    public List<CoronaVaccinationRecord> getAll() {
        return records;
    }

    @Override
    public CoronaVaccinationRecord getById(int coronaVaccinationRecordId) {
        for (CoronaVaccinationRecord record:records
             ) {
            if(coronaVaccinationRecordId == record.getCoronaVaccinationRecordId()){
                this.record = record;
            }

        }
        return record;
    }

    @Override
    public int create(NewCoronaVaccinationRecord coronaVaccinationRecord) {
        return newId;
    }
}
