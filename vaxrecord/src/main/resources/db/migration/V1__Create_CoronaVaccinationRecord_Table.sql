DROP TABLE IF EXISTS corona_vaccination_record;

CREATE TABLE corona_vaccination_record
(
    corona_vaccination_record_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name  TEXT    NOT NULL,
    last_name   TEXT    NOT NULL,
    vaccine_type TEXT   NOT NULL,
    vaccinated_date  DATETIME    NOT NULL,
    times   INT NOT NULL,
    note    TEXT NOT NULL
)