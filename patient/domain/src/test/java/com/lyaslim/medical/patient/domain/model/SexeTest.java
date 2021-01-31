package com.lyaslim.medical.patient.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SexeTest {
    @Test
    void shouldReturnSexeTest() {
        Assertions.assertEquals(Sexe.MALE, Sexe.from(1));
        Assertions.assertEquals(Sexe.FEMALE, Sexe.from(2));
    }
    @Test
    void shouldThrowExceptionTest(){
       Assertions.assertThrows(IllegalArgumentException.class,() -> Sexe.from(-1));
       Assertions.assertThrows(IllegalArgumentException.class,() -> Sexe.from(0));
       Assertions.assertThrows(IllegalArgumentException.class,() -> Sexe.from(5));


    }
}