package health.vaxrecord.application;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.IdDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coronarecords")
public class CoronaVaccinationRecordsController {

    @Autowired
    private CoronaVaccinationRecordsRepo repo;

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
