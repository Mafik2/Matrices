package cz.educanet.matrices.matrixTests;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class transposeMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Return_TransposedMatrix1() {
        double[][] originalData = {{2, 3}, {1,9}, {8,5}};
        IMatrix matrix = matrixFactory.create(originalData);
        double[][] expectedResult = {{2,1,8}, {3, 9, 5}};
        matrixEquals(matrix.transpose(), expectedResult);
    }

    public static void matrixEquals(IMatrix m, double[][] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                Assertions.assertEquals(d[i][j], m.get(i, j));
            }
        }
    }
}