/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhrimaz;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhrimaz
 */
public class TriangleTest {

    @Test
    public void testInvalidTriangle() {
        assertEquals("Unable to detect invalid trinagle",
                Triangle.detectTriangle(Arrays.asList(1, 3, 5)),
                Triangle.TriangleType.INVALID);
        assertEquals("Unable to detect invalid trinagle [CHECK OVERFLOW]",
                Triangle.detectTriangle(Arrays.asList(Integer.MAX_VALUE, 10, Integer.MAX_VALUE - 10)),
                Triangle.TriangleType.INVALID);
    }

    @Test
    public void testValidTriangle() {
        assertNotEquals("Unable to detect valid trinagle",
                Triangle.detectTriangle(Arrays.asList(4, 3, 5)),
                Triangle.TriangleType.INVALID);
        assertNotEquals("Unable to detect valid trinagle [CHECK OVERFLOW]",
                Triangle.detectTriangle(Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                Triangle.TriangleType.INVALID);
        assertNotEquals("Unable to detect valid trinagle [CHECK OVERFLOW]",
                Triangle.detectTriangle(Arrays.asList(Integer.MAX_VALUE, 1, Integer.MAX_VALUE)),
                Triangle.TriangleType.INVALID);
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("Unable to detect valid SCALENE trinagle",
                Triangle.detectTriangle(Arrays.asList(4, 3, 5)),
                Triangle.TriangleType.SCALENE);
        assertEquals("Unable to detect valid SCALENE trinagle",
                Triangle.detectTriangle(Arrays.asList(5, 3, 7)),
                Triangle.TriangleType.SCALENE);
        assertEquals("Unable to detect valid SCALENE trinagle [CHECK OVERFLOW]",
                Triangle.detectTriangle(Arrays.asList(2147483640, 2147483644, 7)),
                Triangle.TriangleType.SCALENE);
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("Unable to detect ISOSCELES trinagle",
                Triangle.detectTriangle(Arrays.asList(4, 3, 3)),
                Triangle.TriangleType.ISOSCELES);
        assertNotEquals("Unable to detect invalid trinagle",
                Triangle.detectTriangle(Arrays.asList(3, 3, 7)),
                Triangle.TriangleType.ISOSCELES);
        assertEquals("Unable to detect ISOSCELES trinagle [CHECK OVERFLOW]",
                Triangle.detectTriangle(Arrays.asList(Integer.MAX_VALUE, 1, Integer.MAX_VALUE)),
                Triangle.TriangleType.ISOSCELES);
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals("Unable to detect EQUILATERAL trinagle",
                Triangle.detectTriangle(Arrays.asList(3, 3, 3)),
                Triangle.TriangleType.EQUILATERAL);
        assertEquals("Unable to detect EQUILATERAL trinagle [CHECK OVERFLOW]",
                Triangle.detectTriangle(Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                Triangle.TriangleType.EQUILATERAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        Triangle.detectTriangle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSizeInput() {
        Triangle.detectTriangle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLengthInput() {
        Triangle.detectTriangle(Arrays.asList(1, 2));
    }
}
