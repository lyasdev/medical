package com.lyaslim.medical.patient.domain.ports.out;

import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.model.Traitement;

public interface MedicamentRepository extends CommonRepository<Medicament, Long> {

}
