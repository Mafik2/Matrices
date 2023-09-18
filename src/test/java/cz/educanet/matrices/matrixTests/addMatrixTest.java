package cz.educanet.matrices.matrixTests;

import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class addMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void shouldSucceedWhenAddMatrixFits() {
        double[][] input1 = {{1, 2, 3, 4}, {0, 0, 0, 0}};
        double[][] input2 = {{0, 0, 0, 0}, {5, 6, 7, 8}};
        double[][] expectedResult = {{1, 2, 3, 4}, {5, 6, 7, 8}};

        Matrix matrix = new Matrix(input1);
        Matrix matrix2 = new Matrix(input2);
        Matrix expected = (Matrix) matrix.add(matrix2);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult[0].length; j++) {
                Assertions.assertEquals(expectedResult[i][j], expected.get(i, j));
            }
        }
    }
}