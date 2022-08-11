package health.vaxrecord.domain.model;

import java.time.LocalDateTime;

public class NewCoronaVaccinationRecord {
     String firstName;
     String lastName;
     String vaccineType;
     LocalDateTime vaccinatedDate;
     int times;
     String note;

     public NewCoronaVaccinationRecord(String firstName, String lastName, String vaccineType, LocalDateTime vaccinatedDate, int times, String note) {
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
}
