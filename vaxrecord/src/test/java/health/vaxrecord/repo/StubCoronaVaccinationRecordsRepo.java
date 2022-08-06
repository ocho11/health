package health.vaxrecord.repo;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class StubCoronaVaccinationRecordsRepo implements CoronaVaccinationRecordsRepo {

    final private CoronaVaccinationRecordDTO coronaVaccinationRecord1 = new CoronaVaccinationRecordDTO(1, "Och", "pfizer", LocalDateTime.of(2022, 8, 8, 8, 8, 8), "no problem");
    final private CoronaVaccinationRecordDTO coronaVaccinationRecord2 = new CoronaVaccinationRecordDTO(2, "Od", "pfizer", LocalDateTime.of(2022, 5, 5, 5, 5, 5), "it's good");
    final private List<CoronaVaccinationRecordDTO> coronaVaccinationRecords = asList(coronaVaccinationRecord1, coronaVaccinationRecord2);

    @Override
    public List<CoronaVaccinationRecordDTO> getAll() {
        return coronaVaccinationRecords;
    }
}
