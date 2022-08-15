import VaxRecordDTO from "../DTO/VaxRecordDTO";

interface VaxRecordRepo {
    getList: ()=> Promise<VaxRecordDTO[]>
}

export default VaxRecordRepo