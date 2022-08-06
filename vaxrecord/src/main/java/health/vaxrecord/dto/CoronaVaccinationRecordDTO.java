package health.vaxrecord.dto;

import java.time.LocalDateTime;

public class CoronaVaccinationRecordDTO {
    private int coronaVaccinationRecordId;
    private String personName;
    private String vaccineType;
    private LocalDateTime vaccinationDate;
    private String note;

    public CoronaVaccinationRecordDTO(int coronaVaccinationRecordId, String personName, String vaccineType, LocalDateTime vaccinationDate, String note) {
        this.coronaVaccinationRecordId = coronaVaccinationRecordId;
        this.personName = personName;
        this.vaccineType = vaccineType;
        this.vaccinationDate = vaccinationDate;
        this.note = note;
    }

    public int getCoronaVaccinationRecordId() {
        return coronaVaccinationRecordId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public LocalDateTime getVaccinationDate() {
        return vaccinationDate;
    }

    public String getNote() {
        return note;
    }
}
