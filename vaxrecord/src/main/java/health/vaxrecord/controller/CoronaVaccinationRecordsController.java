package health.vaxrecord.controller;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.repo.CoronaVaccinationRecordsRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoronaVaccinationRecordsController {

    private CoronaVaccinationRecordsRepo repo;
    public CoronaVaccinationRecordsController(CoronaVaccinationRecordsRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/coronarecords")
    public List<CoronaVaccinationRecordDTO> getRecords() {
        return repo.getAll();
    }

    @GetMapping("/coronarecords/{coronaVaccinationRecordId}")
    public CoronaVaccinationRecordDTO getById(@PathVariable int coronaVaccinationRecordId){
        return repo.getById(coronaVaccinationRecordId);
    }
}
