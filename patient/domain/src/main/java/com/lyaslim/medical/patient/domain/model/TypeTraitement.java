package com.lyaslim.medical.patient.domain.model;

public enum TypeTraitement {

    ORDONNANCE(1, "Ordonnance"), AUTRES(2, "Autres traitements");

    private final int id;
    private final String label;

    TypeTraitement(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TypeTraitement from(int id){
        if (id <= 0 || id > TypeTraitement.values().length) {
            throw new IllegalArgumentException();
        }
        return TypeTraitement.values()[id - 1];
    }
}
