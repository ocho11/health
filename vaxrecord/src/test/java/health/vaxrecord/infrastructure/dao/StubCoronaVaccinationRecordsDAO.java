package health.vaxrecord.infrastructure.dao;


import health.vaxrecord.domain.model.CoronaVaccinationRecord;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StubCoronaVaccinationRecordsDAO implements CoronaVaccinationRecordsDAO {

    final private List<CoronaVaccinationRecord> records = new ArrayList<>(Arrays.asList(new CoronaVaccinationRecord(1, "stubFirstName1",
                    "stubLastName1", "stubPfizer1",
                    LocalDateTime.of(2022, 8, 8, 8, 8, 8), 2, "stub no problem1"),
            new CoronaVaccinationRecord(2, "stubFirstName2", "stubLastName2", "stubPfizer2",
                    LocalDateTime.of(2022, 5, 5, 5, 5, 5), 3, "stub no problem2")));
    private CoronaVaccinationRecord record;

    @Override
    public List<CoronaVaccinationRecord> getAll() {
        return records;
    }

    @Override
    public CoronaVaccinationRecord getById(int id) {
        for (CoronaVaccinationRecord record:
             records) {
            if(record.getCoronaVaccinationRecordId() == id){
                this.record = record;
                break;
            }
        }
        return record;
    }

    @Override
    public int create(NewCoronaVaccinationRecord newCoronaVaccinationRecord) {
        return 3;
    }
}
