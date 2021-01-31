
DROP TABLE IF EXISTS PATIENT;
CREATE TABLE PATIENT (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    date_of_birth DATE NOT NULL,
    sexe integer,
    PRIMARY KEY (id)
);



INSERT INTO PATIENT ( first_name, last_name, date_of_birth, sexe)
              VALUES('BOURAHLA','Slimane',{ts '1985-01-21'}, 1);
INSERT INTO PATIENT ( first_name, last_name, date_of_birth, sexe)
              VALUES('SAID AISSA','Lyes',{ts '1988-01-10'}, 1);
