import VaxRecordDTO from "../DTO/VaxRecordDTO";
import IdDTO from "../DTO/IdDTO";
import NewVaxRecordDTO from "../DTO/NewVaxRecordDTO";

interface VaxRecordRepo {
    getList: ()=> Promise<VaxRecordDTO[]>
    create: (newVaxRecord: NewVaxRecordDTO) => Promise<IdDTO>
}

export default VaxRecordRepo