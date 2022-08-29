import {useState} from "react";
import VaxRecordRepo from "../Repository/VaxRecordRepo";
import {useNavigate} from "react-router";
import NewVaxRecordDTO from "../DTO/NewVaxRecordDTO";
import './vaxRecordNew.scss'

type VaxRecordProps = {
    vaxRecordRepo: VaxRecordRepo
}

function VaxRecordNew(props: VaxRecordProps) {
    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [vaccineType, setVaccineType] = useState("")
    const [times, setTimes] = useState(0)
    const [note, setNote] = useState("")
    let vaccinateDate: string = ''
    let navigate = useNavigate()

    function registerButtonClicked() {
        let clickedDate = new Date(),
            month = '' + (clickedDate.getMonth() + 1),
            day = '' + clickedDate.getDate(),
            hour = '' + clickedDate.getHours(),
            minute = '' + clickedDate.getMinutes(),
            year = clickedDate.getFullYear();

        let registeredDate: String

        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;
        if (hour.length < 2)
            hour = '0' + hour;
        if (day.length < 2)
            minute = '0' + minute;
        registeredDate = [year, month, day].join('-');
        vaccinateDate = registeredDate + 'T' + hour + ':' + minute;
        const registerConfirmed = window.confirm("Do you want to register?")
        if (registerConfirmed) {
            props.vaxRecordRepo.create(new NewVaxRecordDTO(firstName, lastName, vaccineType, vaccinateDate, times, note)).then(() => navigate('/coronarecords/'))
        }
    }

    function vaxRecordListLinkClicked() {
        navigate('/coronarecords/');
    }

    return (
        <div className="new-vax-record">
            <div className="link-to-vax-record-list" onClick={vaxRecordListLinkClicked}>Corona Vaccination Record List
            </div>
            <div className="header">Corona Vaccination Data Register</div>

            <div className="body">
                <div className="field first name">
                    <label>First Name</label>
                    <input type="text" onChange={(e) => setFirstName(e.target.value)}/>
                </div>
                <div className="field last name">
                    <label>Last Name</label>
                    <input type="text" onChange={(e) => setLastName(e.target.value)}/>
                </div>
                <div className="field vaccine type">
                    <label>Vaccination Type</label>
                    <input type="text" onChange={(e) => setVaccineType(e.target.value)}/>
                </div>
                <div className="field times">
                    <label>Times</label>
                    <input type="text" onChange={(e) => setTimes(parseInt(e.target.value))}/>
                </div>
                <div className="field note">
                    <label>Note</label>
                    <input type="text" onChange={(e) => setNote(e.target.value)}/>
                </div>
            </div>
            <button className="register-button" onClick={registerButtonClicked}>Register</button>
        </div>
    )
}

export default VaxRecordNew