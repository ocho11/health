package health.vaxrecord.domain.model;

import java.time.LocalDateTime;

public class CoronaVaccinationRecord {
    int coronaVaccinationRecordId;
    String firstName;
    String lastName;
    String vaccineType;
    LocalDateTime vaccinatedDate;
    int times;
    String note;

    public CoronaVaccinationRecord(int coronaVaccinationRecordId, String firstName, String lastName, String vaccineType, LocalDateTime vaccinatedDate, int times, String note) {
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

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
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
}