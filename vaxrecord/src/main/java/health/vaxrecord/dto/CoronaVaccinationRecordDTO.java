package health.vaxrecord.dto;

import java.time.LocalDateTime;

public class CoronaVaccinationRecordDTO {
    private int coronaVaccinationRecordId;
    private String firstName;
    private String lastName;
    private String vaccineType;
    private LocalDateTime vaccinatedDate;
    private int times;

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

    private String note;
}
