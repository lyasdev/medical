
CREATE TABLE CONSULTATION (
	id integer auto_increment NOT NULL,
	date DATE NOT NULL,
	histoire_maladie VARCHAR(2056),
	patient_id bigint NOT NULL,
	CONSTRAINT consultation_pk PRIMARY KEY (id),
	foreign key (patient_id) references PATIENT(id)
);

INSERT INTO CONSULTATION (date,histoire_maladie,patient_id)
VALUES({ts '1985-01-21'},'Atteint d''une insuffisance renale terminal a lage de 25 ans',1
);
INSERT INTO CONSULTATION (date,histoire_maladie,patient_id)
VALUES({ts '2010-11-21'},'Atteint d''un diabète renale terminal a lage de 30 ans',2
);
INSERT INTO CONSULTATION (date,histoire_maladie,patient_id)
VALUES({ts '2000-10-21'},'Atteint d''un diabète renale terminal a lage de 30 ans',1
);
