package health.vaxrecord.repo.dao;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StubCoronaVaccinationRecordsDAO implements CoronaVaccinationRecordsDAO {

    final private List<CoronaVaccinationRecordDTO> records = new ArrayList<>(Arrays.asList(new CoronaVaccinationRecordDTO(1, "stubDTOFirstName1",
                    "stubDTOLastName1", "stubDTOPfizer1",
                    LocalDateTime.of(2022, 8, 8, 8, 8, 8), 2, "stubDTO no problem1"),
            new CoronaVaccinationRecordDTO(2, "stubDTOFirstName2", "stubDTOLastName2", "stubDTOPfizer2",
                    LocalDateTime.of(2022, 5, 5, 5, 5, 5), 3, "stubDTO no problem2")));
    private CoronaVaccinationRecordDTO record;

    @Override
    public List<CoronaVaccinationRecordDTO> getAll() {
        return records;
    }

    @Override
    public CoronaVaccinationRecordDTO getById(int id) {
        for (CoronaVaccinationRecordDTO record:
             records) {
            if(record.getCoronaVaccinationRecordId() == id){
                this.record = record;
                break;
            }
        }
        return record;
    }
}
