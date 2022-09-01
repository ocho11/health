import StubVaxRecordRepo from "../Repository/StubVaxRecordRepo";
import {render, waitFor} from "@testing-library/react";
import VaxRecordList from "./VaxRecordList";
import {BrowserRouter as Router} from "react-router-dom";

describe('AnnouncementList', () => {
        let vaxxRecordRepo: StubVaxRecordRepo

        beforeEach(() => {
            vaxxRecordRepo = new StubVaxRecordRepo()
        })

        it('Does exist Vaccination Record List, First Name, Last Name, Vaccination Type, Times, Note', async () => {
            const renderedComponent = render(
                <Router>
                    <VaxRecordList vaxRecordRepo={vaxxRecordRepo}/>
                </Router>)
            await waitFor(() => {
                    expect(renderedComponent.getByText('Vaccination Record List')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('First Name')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('Last Name')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('Vaccination Type')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('Times')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('Note')).toBeInTheDocument()
                }
            )
        })

        it('Does exist stubFirstName1, stubLastName1, stubVaccineType1, stubNote1', async () => {
            const renderedComponent = render(
                <Router>
                    <VaxRecordList vaxRecordRepo={vaxxRecordRepo}/>
                </Router>)
            await waitFor(() => {
                    expect(renderedComponent.getByText('stubFirstName1')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('stubLastName1')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('stubVaccineType1')).toBeInTheDocument(),
                        expect(renderedComponent.getByText('stubNote1')).toBeInTheDocument()
                }
            )
        })
    }
)