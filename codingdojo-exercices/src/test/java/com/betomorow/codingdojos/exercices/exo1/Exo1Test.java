package com.betomorow.codingdojos.exercices.exo1;

import org.junit.Test;

import static com.betomorow.codingdojos.exercices.exo1.GamificationHelper.validateMedal;
import static org.junit.Assert.assertTrue;

public class Exo1Test {
    @Test
    public void testRegex() throws Exception {
        Exo1 exo1 = new Exo1();
        assertTrue("hello".matches(exo1.getRegex()));

        validateMedal("id1", true);
    }
}