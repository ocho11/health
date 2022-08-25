import React from 'react';
import VaxRecordList from "./VaxRecord/View/VaxRecordList";
import BrowserFetchWrapper from "./VaxRecord/Network/BrowserFetchWrapper";
import NetworkVaxRecordsRepo from "./VaxRecord/Repository/NetworkVaxRecordsRepo";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import VaxRecordNew from "./VaxRecord/View/VaxRecordNew";

function App() {
    const browserFetchWrapper = new BrowserFetchWrapper()
    const vaxRecordRepo = new NetworkVaxRecordsRepo(browserFetchWrapper)

    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/coronarecords"
                           element={<VaxRecordList vaxRecordRepo={vaxRecordRepo}/>}/>
                    <Route path="/coronarecords/create" element={<VaxRecordNew vaxRecordRepo={vaxRecordRepo}/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;