package health.vaxrecord.application.dto;

import health.vaxrecord.domain.model.NewCoronaVaccinationRecord;

import java.time.LocalDateTime;

public class NewCoronaVaccinationRecordDTO {
    private String firstName;
    private String lastName;
    private String vaccineType;
    private LocalDateTime vaccinatedDate;
    private int times;
    private String note;

    public NewCoronaVaccinationRecordDTO() {
    }

    public NewCoronaVaccinationRecordDTO(String firstName, String lastName, String vaccineType, LocalDateTime vaccinatedDate, int times, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccineType = vaccineType;
        this.vaccinatedDate = vaccinatedDate;
        this.times = times;
        this.note = note;
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

    public NewCoronaVaccinationRecord convertToDomain() {
        return new NewCoronaVaccinationRecord(
                this.firstName,
                this.lastName,
                this.vaccineType,
                this.vaccinatedDate,
                this.times,
                this.note);
    }
}
