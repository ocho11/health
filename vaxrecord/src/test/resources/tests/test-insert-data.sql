DELETE FROM corona_vaccination_record;
INSERT INTO corona_vaccination_record(corona_vaccination_record_id, first_name,last_name, vaccine_type,
vaccinated_date, times, note)
VALUES
(1001, 'testFirstName1', 'testLastName1', 'pfizer1', '2022-12-23 16:00:00', 1, 'ok'),
(1002, 'testFirstName2', 'testLastName2', 'pfizer2', '2022-05-23 16:00:00', 2, 'not ok'),
(1003, 'testFirstName3', 'testLastName3', 'pfizer3', '2022-03-23 16:00:00', 3, 'no problem');