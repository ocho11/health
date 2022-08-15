import React from 'react';
import VaxRecordList from "./VaxRecord/View/VaxRecordList";
import BrowserFetchWrapper from "./VaxRecord/Network/BrowserFetchWrapper";
import NetworkVaxRecordsRepo from "./VaxRecord/Repository/NetworkVaxRecordsRepo";

function App() {
    const browserFetchWrapper = new BrowserFetchWrapper()
    const vaxRecordRepo = new NetworkVaxRecordsRepo(browserFetchWrapper)

    return (
        <div className="App">
            <VaxRecordList vaxRecordRepo={vaxRecordRepo}/>
        </div>
    );
}

export default App;