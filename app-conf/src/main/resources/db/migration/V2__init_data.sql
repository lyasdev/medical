INSERT INTO PATIENT ( first_name,middle_name, last_name, birth_date, sexe, identity_card_number, blood_group)
              VALUES('BOURAHLA','Slim','Slimane',to_date('21/01/1985', 'dd/mm/yyyy'), 1,'0019826354',1);
INSERT INTO PATIENT ( first_name,middle_name, last_name, birth_date, sexe, identity_card_number, blood_group)
              VALUES('SAID AISSA','SAID','Lyes',to_date('10/01/1988', 'dd/mm/yyyy'), 1,'1298876543',2);
              
 
INSERT INTO CONSULTATION (date,histoire_maladie,patient_id)
VALUES('1985-01-21','Atteint d''une insuffisance renale terminal a lage de 25 ans',1
);
INSERT INTO CONSULTATION (date,histoire_maladie,patient_id)
VALUES('2010-11-21','Atteint d''un diabète renale terminal a lage de 30 ans',2
);
INSERT INTO CONSULTATION (date,histoire_maladie,patient_id)
VALUES('2000-10-21','Atteint d''un diabète renale terminal a lage de 30 ans',1
);

INSERT INTO MEDICAMENT (dci,nom_commercial, description, indications, contre_indication)
VALUES('PARACETAMOL','DOLIPRANE','Médicament contre la fievre et les douleurs',
'A utiliser apres les repas', 'A ne pas utiliser si vous avez des allergies'
);
INSERT INTO MEDICAMENT (dci,nom_commercial, description, indications, contre_indication)
VALUES('PARACETAMOL','PARALGAN','Médicament contre la fievre et les douleurs',
'A utiliser apres les repas', 'A ne pas utiliser si vous avez des allergies'
);

INSERT INTO TRAITEMENT (date_trt, type_trt,CONSULTATION_ID)
VALUES ('2021-01-21',1,1);
INSERT INTO TRAITEMENT (date_trt, type_trt,CONSULTATION_ID)
VALUES ('2021-10-21',1,1);

INSERT INTO MEDICAMENT_TRAITEMENT (MEDICAMENT_ID, TRAITEMENT_ID)  VALUES (1,1);
INSERT INTO MEDICAMENT_TRAITEMENT (MEDICAMENT_ID, TRAITEMENT_ID)  VALUES (1,2);