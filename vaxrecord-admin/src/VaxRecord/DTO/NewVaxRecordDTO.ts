class NewVaxRecordDTO {
    firstName: string
    lastName: string
    vaccineType: string
    vaccinatedDate: string
    times: number
    note: string

    constructor(firstName: string, lastName: string, vaccineType: string, vaccinatedDate: string, times: number, note: string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccineType = vaccineType;
        this.vaccinatedDate = vaccinatedDate;
        this.times = times;
        this.note = note;
    }
}

export default NewVaxRecordDTO