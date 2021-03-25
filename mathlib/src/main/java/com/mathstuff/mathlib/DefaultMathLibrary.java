/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.mathstuff.mathlib;

import java.util.Arrays;
import com.matrixstuff.matrixlib.Matrix;

public class DefaultMathLibrary implements MathLibrary {
    @Override
    public Double[] convert(String commaDelimitedNumbers) {
        String[] stringValues = commaDelimitedNumbers.split(",");
        return Arrays.stream(stringValues).map(Double::valueOf).toArray(Double[]::new);
    }

    @Override
    public Matrix convertToMatrix(String commaDelimitedNumbers) {
        String[] stringValues = commaDelimitedNumbers.split(",");
        return Matrix.of(Arrays.stream(stringValues).map(Double::valueOf).toArray(Double[]::new));
    }

    protected DefaultMathLibrary() {

    }
}