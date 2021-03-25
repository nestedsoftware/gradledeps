package com.mathstuff.mathlib;

import com.matrixstuff.matrixlib.Matrix;

public interface MathLibrary {
    Double[] convert(String commaDelimitedNumbers);
    Matrix convertToMatrix(String commaDelimitedNumbers);
    static MathLibrary create() {
        return new DefaultMathLibrary();
    }
}
