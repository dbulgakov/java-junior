package com.acme.edu.utils;


import java.util.Arrays;

public class BoxingUtils {
    public static Integer[][] boxMatrix(int[][] matrixToBox) {
        return Arrays.stream(matrixToBox)
                .parallel()
                .map(BoxingUtils::boxArray)
                .toArray(Integer[][]::new);
    }

    public static Integer[] boxArray(int[] arrayToBox) {
        return Arrays.stream(arrayToBox).boxed().toArray(Integer[]::new);
    }
}
