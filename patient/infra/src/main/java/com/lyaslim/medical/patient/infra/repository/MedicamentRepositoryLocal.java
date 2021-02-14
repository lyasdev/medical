package com.lyaslim.medical.patient.infra.repository;

import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.model.Traitement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepositoryLocal extends CrudRepository<Medicament, Long> {

}
