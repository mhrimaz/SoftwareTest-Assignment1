/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhrimaz;

import java.util.List;

public class Triangle {
    public enum TriangleType {EQUILATERAL,ISOSCELES,SCALENE,INVALID}
    public static TriangleType detectTriangle(List<Integer> inputs){
        if(inputs == null || inputs.size()!=3){
            throw new IllegalArgumentException("Illegal Input. only 3 integers is valid.");
        }
        long sideA = inputs.get(0);
        long sideB = inputs.get(1);
        long sideC = inputs.get(2);

        //Check sides size validity
        if(sideA<=0 || sideB <=0 || sideC <=0){
            throw new IllegalArgumentException("parameters should be positive and non zero");
        }

        //check triangle inequality
        if(sideA >= sideB + sideC || sideB >= sideA + sideC || sideC >= sideA + sideB) {
            return TriangleType.INVALID;
        }
        if(sideA == sideB && sideB == sideC){
            return TriangleType.EQUILATERAL;
        }else if(sideA == sideB || sideB == sideC || sideC == sideA){
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }
}
