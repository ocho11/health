import VaxRecordRepo from "./VaxRecordRepo";
import VaxRecordDTO from "../DTO/VaxRecordDTO";
import FetchWrapper from "../Network/FetchWrapper";
import NewVaxRecordDTO from "../DTO/NewVaxRecordDTO";
import IdDTO from "../DTO/IdDTO";

class NetworkVaxRecordsRepo implements VaxRecordRepo {

    private fetchWrapper: FetchWrapper

    constructor(fetchWrapper: FetchWrapper) {
        this.fetchWrapper = fetchWrapper;
    }

    getList(): Promise<VaxRecordDTO[]> {
        const options = {
            method: 'GET',
        }
        return this.fetchWrapper.fetchJson('http://localhost:8080/coronarecords/', options)
            .then(records => records.map((recordJson: any) => VaxRecordDTO.fromJSON(recordJson)))
    }

    create(newVaxRecord: NewVaxRecordDTO): Promise<IdDTO> {
        const options = {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newVaxRecord)
        }
        return this.fetchWrapper.fetchJson('http://localhost:8080/coronarecords', options)
    }
}

export default NetworkVaxRecordsRepo