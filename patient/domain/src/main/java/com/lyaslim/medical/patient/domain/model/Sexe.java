package com.lyaslim.medical.patient.domain.model;

public enum Sexe {

    MALE(1, "Masculin"), FEMALE(2, "Feminin");
	
	private static final Sexe[] VALUES = Sexe.values();

    private final int id;
    private final String label;

    Sexe(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }
    
    public String getLabel() {
    	return label;
    }

    public static Sexe from(int id){
    	if (id <= 0 || id > VALUES.length) {
    		throw new IllegalArgumentException();
    	}
        return VALUES[id - 1];
    }
}
