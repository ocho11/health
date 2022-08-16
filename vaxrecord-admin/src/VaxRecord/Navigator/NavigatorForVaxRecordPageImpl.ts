import {NavigatorForVaxRecordPage} from "./NavigatorForVaxRecordPage";
import { History } from "history";

export class NavigatorForVaxRecordPageImpl implements NavigatorForVaxRecordPage{

    private browserHistory: History

    constructor(browserHistory: History) {
        this.browserHistory = browserHistory
    }

    goToCreateVaxRecord(): void {
        this.browserHistory.push('/coronarecords/create')
    }

    goToVaxRecordList(): void {
        this.browserHistory.push('/coronarecords/')
    }

}