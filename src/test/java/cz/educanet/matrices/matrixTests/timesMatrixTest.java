package cz.educanet.matrices.matrixTests;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class timesMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ThrowIllegalArgumentException_When_ColumnsNotEqualRows() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.createIdentity(3),
                matrixFactory.createZero(4),
                matrixFactory.create(new double[][]{{1, 2, 3}, {4, 5, 6}}),
                matrixFactory.create(new double[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}),
                matrixFactory.create(new double[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}),
        };

        for (int i = 0; i < matrices.length - 1; i++) {
            int finalI = i;
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrices[finalI].times(matrices[finalI + 1]));
        }
    }

    @Test
    public void should_Return_Result_When_ColumnsEqualRows() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{-1, 2, 1}, {2, 0, 4}}),
                matrixFactory.create(new double[][]{{2, -3}, {1, 4}, {-2, 3}})
        };

        double[][][] results = new double[][][]{
                {
                        {-2, 14},
                        {-4, 6}
                }
        };

        for (int i = 0; i < matrices.length; i += 2) {
            matrixEquals(matrices[i].times(matrices[i + 1]), results[i / 2]);
        }
    }
    public static void matrixEquals(IMatrix m, double[][] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                Assertions.assertEquals(d[i][j], m.get(i, j));
            }
        }
    }

}