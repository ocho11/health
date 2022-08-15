class VaxRecordDTO{
    coronaVaccinationRecordId: number
    firstName: string
    lastName: string
    vaccineType: string
    vaccinatedDate: string
    times: number
    note: string

    constructor(coronaVaccinationRecordId: number, firstName: string, lastName: string, vaccineType: string, vaccinatedDate: string, times: number, note: string) {
        this.coronaVaccinationRecordId = coronaVaccinationRecordId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccineType = vaccineType;
        this.vaccinatedDate = vaccinatedDate;
        this.times = times;
        this.note = note;
    }

    static fromJSON(jsonObject: any): VaxRecordDTO {
        return new VaxRecordDTO(
            jsonObject.coronaVaccinationRecordId,
            jsonObject.firstName,
            jsonObject.lastName,
            jsonObject.vaccineType,
            jsonObject.vaccinatedDate,
            jsonObject.times,
            jsonObject.note)
    }
}

export default VaxRecordDTO