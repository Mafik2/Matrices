package cz.educanet.matrices.matrixFactoryTests;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class createDiagonalTest {

    private IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ThrowException_When_EmptyMatrix() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createDiagonal(new double[]{}));
    }

    @Test
    public void should_Succeed_When_ValidNumber() {
        double[][] diagonal = new double[][]{{0, 1, 2, 3}, {4, 5, 5, 6}, {8, 9, 10, 10,}};

        for (double[] diagonal2 : diagonal) {
            IMatrix matrix = matrixFactory.createDiagonal(diagonal2);
            diagonalChecker(matrix, diagonal2);
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