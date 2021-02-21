
CREATE TABLE TRAITEMENT(
	id integer auto_increment NOT NULL,
	date_trt DATE NOT NULL,
	type_trt Integer NOT NULL,
	CONSULTATION_ID bigint null,
	CONSTRAINT traitement_pk PRIMARY KEY (id),
	foreign key (CONSULTATION_ID) references CONSULTATION(id)
);

INSERT INTO TRAITEMENT (date_trt, type_trt,CONSULTATION_ID)
VALUES ({ts '2021-01-21'},1,1);
INSERT INTO TRAITEMENT (date_trt, type_trt,CONSULTATION_ID)
VALUES ({ts '2021-10-21'},1,1);