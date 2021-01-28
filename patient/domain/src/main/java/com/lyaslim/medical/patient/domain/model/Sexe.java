package com.lyaslim.medical.patient.domain.model;

public enum Sexe {

    MALE(1), FEMALE(2);

    private int id;

    Sexe(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Sexe from(int id){
        return Sexe.values()[id];
    }
}
