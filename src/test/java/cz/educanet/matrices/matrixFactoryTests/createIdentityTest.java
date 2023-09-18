package cz.educanet.matrices.matrixFactoryTests;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class createIdentityTest {
    private IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ThrowException_When_EmptyMatrix() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createDiagonal(new double[]{}));
    }

    @Test
    public void should_ThrowException_When_NegativeNumber() {
        int negativeNumber = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            matrixFactory.createIdentity(negativeNumber);
        });
    }

    @Test
    public void should_Succeed_When_ValidSize() {
        int[] size = {1, 3, 6, 7, 2};

        for (int size2 : size) {
            IMatrix matrix = matrixFactory.createIdentity(size2);
            Assertions.assertEquals(size2, matrix.getColumns());
            Assertions.assertEquals(size2, matrix.getRows());
        }
    }


    public static void diagonalChecker(IMatrix m, double[] diagonal) {
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal.length; j++) {
                if (i == j) assertEquals(diagonal[i], m.get(i, j));
                else assertEquals(0, m.get(i, j));
            }
        }
    }
}