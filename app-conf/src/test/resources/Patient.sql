
DROP TABLE IF EXISTS PATIENT;
CREATE TABLE PATIENT (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    date_of_birth DATE NOT NULL,
    sexe integer,
    PRIMARY KEY (id)
);



INSERT INTO PATIENT ( first_name, last_name, date_of_birth, sexe)
              VALUES('BOURAHLA','Slimane',CURRENT_DATE(),1);
INSERT INTO PATIENT ( first_name, last_name, date_of_birth, sexe)
              VALUES('SAID AISSA','Lyes',CURRENT_DATE(),1);
