import VaxRecordRepo from "./VaxRecordRepo";
import VaxRecordDTO from "../DTO/VaxRecordDTO";
import FetchWrapper from "../Network/FetchWrapper";

class NetworkVaxRecordsRepo implements VaxRecordRepo{
    private fetchWrapper: FetchWrapper


    constructor(fetchWrapper: FetchWrapper) {
        this.fetchWrapper = fetchWrapper;
    }



    getList(): Promise<VaxRecordDTO[]> {
        return this.fetchWrapper.getByJson('http://localhost:8080/coronarecords/')
            .then(records => records.map((recordJson: any) => VaxRecordDTO.fromJSON(recordJson)))
    }

}

export default NetworkVaxRecordsRepo