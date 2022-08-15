package health.vaxrecord.application;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.IdDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coronarecords")
@CrossOrigin(origins = "*")
public class CoronaVaccinationRecordsController {

    @Autowired
    private CoronaVaccinationRecordsRepo repo;

    public CoronaVaccinationRecordsController(CoronaVaccinationRecordsRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CoronaVaccinationRecordDTO> getRecords() {
        return repo.getAll().stream()
                .map(CoronaVaccinationRecordDTO::from)
                .collect(Collectors.toList());

    }

    @GetMapping("/{coronaVaccinationRecordId}")
    public CoronaVaccinationRecordDTO getById(@PathVariable int coronaVaccinationRecordId) {
        return CoronaVaccinationRecordDTO.from(repo.getById(coronaVaccinationRecordId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdDTO create(@RequestBody NewCoronaVaccinationRecordDTO coronaVaccinationRecordDTO){
        int id = repo.create(coronaVaccinationRecordDTO.convertToDomain());
        return new IdDTO(id);
    }

    @DeleteMapping("/{coronaVaccinationRecordId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRe(@PathVariable int coronaVaccinationRecordId){
        repo.delete(coronaVaccinationRecordId);
    }
}