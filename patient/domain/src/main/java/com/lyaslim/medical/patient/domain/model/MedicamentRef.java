package com.lyaslim.medical.patient.domain.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Table;

@Table("MEDICAMENT_TRAITEMENT")
@Value
@RequiredArgsConstructor
public class MedicamentRef {
    Long medicamentId;
}
