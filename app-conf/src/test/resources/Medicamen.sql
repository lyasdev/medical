
CREATE TABLE MEDICAMENT (
	id integer auto_increment NOT NULL,
	dci VARCHAR(100) NOT NULL,
	nom_commercial VARCHAR(200) NOT NULL,
	description VARCHAR(200) NOT NULL,
	indications VARCHAR(200) NULL,
	contre_indication VARCHAR(200) NULL,
	CONSTRAINT medicament_pk PRIMARY KEY (id)
);

INSERT INTO MEDICAMENT (dci,nom_commercial, description, indications, contre_indication)
VALUES('PARACETAMOL','DOLIPRANE','Médicament contre la fievre et les douleurs',
'A utiliser apres les repas', 'A ne pas utiliser si vous avez des allergies'
);
INSERT INTO MEDICAMENT (dci,nom_commercial, description, indications, contre_indication)
VALUES('PARACETAMOL','PARALGAN','Médicament contre la fievre et les douleurs',
'A utiliser apres les repas', 'A ne pas utiliser si vous avez des allergies'
);

