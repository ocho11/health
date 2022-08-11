package health.vaxrecord.application.dto;

import health.vaxrecord.domain.model.CoronaVaccinationRecord;

import java.time.LocalDateTime;

public class CoronaVaccinationRecordDTO {
    int coronaVaccinationRecordId;
    String firstName;
    String lastName;

    public CoronaVaccinationRecordDTO(int coronaVaccinationRecordId, String firstName, String lastName, String vaccineType, LocalDateTime vaccinatedDate, int times, String note) {
        this.coronaVaccinationRecordId = coronaVaccinationRecordId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccineType = vaccineType;
        this.vaccinatedDate = vaccinatedDate;
        this.times = times;
        this.note = note;
    }

    public int getCoronaVaccinationRecordId() {
        return coronaVaccinationRecordId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public LocalDateTime getVaccinatedDate() {
        return vaccinatedDate;
    }

    public int getTimes() {
        return times;
    }

    public String getNote() {
        return note;
    }

    public void setCoronaVaccinationRecordId(int coronaVaccinationRecordId) {
        this.coronaVaccinationRecordId = coronaVaccinationRecordId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public void setVaccinatedDate(LocalDateTime vaccinatedDate) {
        this.vaccinatedDate = vaccinatedDate;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setNote(String note) {
        this.note = note;
    }

    String vaccineType;
    LocalDateTime vaccinatedDate;
    int times;
    String note;

    public static CoronaVaccinationRecordDTO from(CoronaVaccinationRecord coronaVaccinationRecord) {
        return new CoronaVaccinationRecordDTO(
                coronaVaccinationRecord.getCoronaVaccinationRecordId(),
                coronaVaccinationRecord.getFirstName(),
                coronaVaccinationRecord.getLastName(),
                coronaVaccinationRecord.getVaccineType(),
                coronaVaccinationRecord.getVaccinatedDate(),
                coronaVaccinationRecord.getTimes(),
                coronaVaccinationRecord.getNote()
        );
    }
}