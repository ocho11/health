package health.vaxrecord.controller;

import health.vaxrecord.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.dto.IdDTO;
import health.vaxrecord.dto.NewCoronaVaccinationRecordDTO;
import health.vaxrecord.repo.CoronaVaccinationRecordsRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coronarecords")
public class CoronaVaccinationRecordsController {

    private CoronaVaccinationRecordsRepo repo;

    public CoronaVaccinationRecordsController() {
    }

    public CoronaVaccinationRecordsController(CoronaVaccinationRecordsRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CoronaVaccinationRecordDTO> getRecords() {
        return repo.getAll();
    }

    @GetMapping("/{coronaVaccinationRecordId}")
    public CoronaVaccinationRecordDTO getById(@PathVariable int coronaVaccinationRecordId) {
        return repo.getById(coronaVaccinationRecordId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdDTO create(@RequestBody NewCoronaVaccinationRecordDTO coronaVaccinationRecord){
        int id = repo.create(coronaVaccinationRecord);
        return new IdDTO(id);
    }
}
