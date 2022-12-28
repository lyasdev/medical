package com.lyaslim.medical.patient.infra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lyaslim.medical.patient.domain.model.Traitement;

@Repository
public interface TraitementRepositoryLocal extends CrudRepository<Traitement, Long> {

}
