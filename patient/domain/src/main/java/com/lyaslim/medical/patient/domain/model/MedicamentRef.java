package com.lyaslim.medical.patient.domain.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("MEDICAMENT_TRAITEMENT")
public record MedicamentRef(Long medicamentId) {}
