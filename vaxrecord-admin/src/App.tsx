import React from 'react';
import VaxRecordList from "./VaxRecord/View/VaxRecordList";
import BrowserFetchWrapper from "./VaxRecord/Network/BrowserFetchWrapper";
import NetworkVaxRecordsRepo from "./VaxRecord/Repository/NetworkVaxRecordsRepo";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import VaxRecordNew from "./VaxRecord/View/VaxRecordNew";

function App() {
    const browserFetchWrapper = new BrowserFetchWrapper()
    const vaxRecordRepo = new NetworkVaxRecordsRepo(browserFetchWrapper)

    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path="/coronarecords"
                           element={<VaxRecordList vaxRecordRepo={vaxRecordRepo}/>}/>
                    <Route path="/coronarecords/create" element={<VaxRecordNew vaxRecordRepo={vaxRecordRepo}/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;