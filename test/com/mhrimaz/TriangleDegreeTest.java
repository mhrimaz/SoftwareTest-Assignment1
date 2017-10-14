/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhrimaz;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 *
 * @author mhrimaz
 */
@RunWith(Theories.class)
public class TriangleDegreeTest {

    @DataPoints
    public static int[] list = {-1, 0, 1, 2, 3, 5, 7, 100,300,900};

    @Theory
    public void degreeTheory(int a, int b, int c) {
        Assume.assumeTrue(a > 0 && b > 0 && c > 0);
        Triangle.TriangleType detectTriangle = Triangle.detectTriangle(Arrays.asList(a, b, c));
        Assume.assumeTrue(detectTriangle != Triangle.TriangleType.INVALID);
        double a0 = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        double a1 = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
        double a2 = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        assertEquals("Check Degree Consistency",a0+a1+a2,Math.PI,0.000_000_1);
    }

}
