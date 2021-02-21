package com.lyaslim.medical.patient.domain.model;

public enum BloodGroup {
    O_NEG (1, "O-"),
    O_POS (2, "O+"),
    A_NEG (3, "A-"),
    A_POS (4, "A+"),
    B_NEG (5, "B-"),
    B_POS (6, "B+"),
    AB_NEG (7, "AB-"),
    AB_POS (8, "AB+");

    private static final BloodGroup[] VALUES = BloodGroup.values();

    private final int id;

    private final String label;

    BloodGroup(final int id, final String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static BloodGroup from(int id){
        if (id <= 0 || id > VALUES.length) {
            throw new IllegalArgumentException();
        }
        return VALUES[id - 1];
    }
}
