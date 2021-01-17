/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradledeps.app;

import com.mathstuff.mathlib.MathLibrary;
import com.matrixstuff.matrixlib.Matrix;

public class App {
    public static void main(String[] args) {
        MathLibrary mathlib = new MathLibrary();

        System.out.println("printing values...");
        Double[] values = mathlib.convert("66.3, -2, 900");
        for (Double v : values) {
            System.out.println(v);
        }

        System.out.println("printing matrix values...");
        Matrix matrix = mathlib.convertToMatrix("1, 2.3, 4, -6, 100");
        for (Double v : matrix.getValues()) {
            System.out.println(v);
        }

    }

}
