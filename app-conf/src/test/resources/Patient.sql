DROP TABLE IF EXISTS CONSULTATION;
DROP TABLE IF EXISTS PATIENT;
CREATE TABLE PATIENT (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    middle_name VARCHAR(100) NULL,
    last_name VARCHAR(128) NOT NULL,
    birth_date DATE NOT NULL,
    sexe integer,
    identity_card_number VARCHAR(100)  NULL,
    blood_group INTEGER NULL,

    PRIMARY KEY (id)
);


INSERT INTO PATIENT ( first_name,middle_name, last_name, birth_date, sexe, identity_card_number, blood_group)
              VALUES('BOURAHLA','Slim','Slimane',{ts '1985-01-21'}, 1,'0019826354',1);
INSERT INTO PATIENT ( first_name,middle_name, last_name, birth_date, sexe, identity_card_number, blood_group)
              VALUES('SAID AISSA','SAID','Lyes',{ts '1988-01-10'}, 1,'1298876543',2);
