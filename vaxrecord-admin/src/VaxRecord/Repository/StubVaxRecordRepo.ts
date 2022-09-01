import VaxRecordRepo from "./VaxRecordRepo";
import NewVaxRecordDTO from "../DTO/NewVaxRecordDTO";
import IdDTO from "../DTO/IdDTO";
import VaxRecordDTO from "../DTO/VaxRecordDTO";

class StubVaxRecordRepo implements VaxRecordRepo{
    create(newVaxRecord: NewVaxRecordDTO): Promise<IdDTO> {
        return Promise.resolve(new IdDTO(1))
    }

    getList(): Promise<VaxRecordDTO[]> {
        return Promise.resolve([
            new VaxRecordDTO(1,'stubFirstName1','stubLastName1','stubVaccineType1','2022-09-01T17:50',1,'stubNote1'),
            new VaxRecordDTO(2,'stubFirstName2','stubLastName2','stubLastName2','2022-09-01T17:55',2,'stubNote2')
        ]);
    }

}

export default StubVaxRecordRepo