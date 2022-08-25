import VaxRecordDTO from "../DTO/VaxRecordDTO";
import {useEffect, useState} from "react";
import vaxRecordRepo from "../Repository/VaxRecordRepo";
import './vaxRecordList.scss'
import {useNavigate} from "react-router";


type VaxRecords = {
    vaxRecordRepo: vaxRecordRepo
}

function VaxRecordList(props: VaxRecords) {
    const [vaxRecords, setVaxRecords] = useState([] as VaxRecordDTO[])
    let navigate = useNavigate()

    useEffect(() => {
        props.vaxRecordRepo.getList()
            .then((fetchedVaxRecords) => {
                setVaxRecords(fetchedVaxRecords)
            })
    }, [props.vaxRecordRepo])

    function registerButtonClicked() {
        navigate('/coronarecords/create');
    }

    return (
        <div className="vax-record-list">
            <article>
                <div className="header-item">
                    <div className="page-title">Vaccination Record List</div>
                    <button className="register-button" onClick={registerButtonClicked}>register</button>
                </div>
                <div className="vax-record-table">
                    <div className="header">
                        <div className="first-name">First Name</div>
                        <div className="last-name">Last Name</div>
                        <div className="vaccine-type">Vaccination Type</div>
                        <div className="times">Times</div>
                        <div className="note">Note</div>
                    </div>
                    <div className="body">
                        {vaxRecords.map((vaxRecord, i) => (
                            <div className="vax-record-row" key={i}>
                                <div className="first-name">{vaxRecord.firstName}</div>
                                <div className="last-name">{vaxRecord.lastName}</div>
                                <div className="vaccine-type">{vaxRecord.vaccineType}</div>
                                {/*<div className="registered-date">{vaxRecord.vaccinatedDate}</div>*/}
                                <div className="times">{vaxRecord.times}</div>
                                <div className="note">{vaxRecord.note}</div>
                            </div>
                        ))}
                    </div>
                </div>
            </article>
        </div>
    )
}

export default VaxRecordList