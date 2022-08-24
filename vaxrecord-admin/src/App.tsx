import React from 'react';
import VaxRecordList from "./VaxRecord/View/VaxRecordList";
import BrowserFetchWrapper from "./VaxRecord/Network/BrowserFetchWrapper";
import NetworkVaxRecordsRepo from "./VaxRecord/Repository/NetworkVaxRecordsRepo";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import VaxRecordNew from "./VaxRecord/View/VaxRecordNew";
import {NavigatorForVaxRecordPageImpl} from "./VaxRecord/Navigator/NavigatorForVaxRecordPageImpl";
import {createBrowserHistory, History} from "history";

function App() {
    const browserHistory: History = createBrowserHistory();
    const navigatorPage = new NavigatorForVaxRecordPageImpl(browserHistory);
    const browserFetchWrapper = new BrowserFetchWrapper()
    const vaxRecordRepo = new NetworkVaxRecordsRepo(browserFetchWrapper)

    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/coronarecords"
                           element={<VaxRecordList vaxRecordRepo={vaxRecordRepo} navigatorPage={navigatorPage}/>}/>
                    <Route path="/coronarecords/create" element={<VaxRecordNew vaxRecordRepo={vaxRecordRepo} navigatorPage={navigatorPage}/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;