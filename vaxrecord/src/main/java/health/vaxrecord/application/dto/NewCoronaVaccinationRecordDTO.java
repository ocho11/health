package health.vaxrecord.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class NewCoronaVaccinationRecordDTO {
    private String firstName;
    private String lastName;
    private String vaccineType;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
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
}
