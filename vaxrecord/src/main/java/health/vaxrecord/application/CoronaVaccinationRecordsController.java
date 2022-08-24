package health.vaxrecord.application;

import health.vaxrecord.application.dto.CoronaVaccinationRecordDTO;
import health.vaxrecord.application.dto.IdDTO;
import health.vaxrecord.application.dto.NewCoronaVaccinationRecordDTO;
import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;
import health.vaxrecord.domain.repository.CoronaVaccinationRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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

    @DeleteMapping("/{coronaVaccinationRecordId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteRe(@PathVariable int coronaVaccinationRecordId) {
        repo.delete(coronaVaccinationRecordId);
    }
    @PostMapping
    @ResponseStatus(CREATED)
    public IdDTO create(@RequestBody NewCoronaVaccinationRecordDTO newCoronaVaccinationRecordDTO) {
        NewCoronaVaccinationRecord newCoronaVaccinationRecord =
                new NewCoronaVaccinationRecord(newCoronaVaccinationRecordDTO.getFirstName(),
                newCoronaVaccinationRecordDTO.getLastName(), newCoronaVaccinationRecordDTO.getVaccineType(),
                        newCoronaVaccinationRecordDTO.getVaccinatedDate(),
                newCoronaVaccinationRecordDTO.getTimes(),
                newCoronaVaccinationRecordDTO.getNote());
        int id = repo.create(newCoronaVaccinationRecord);
        return new IdDTO(id);
    }
}