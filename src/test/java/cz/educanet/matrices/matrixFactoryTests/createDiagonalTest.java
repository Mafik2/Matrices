package cz.educanet.matrices.matrixFactoryTests;

import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class createDiagonalTest {

    private IMatrixFactory matrixFactory = MatrixFactory.instance;


    @Test
    public void should_ThrowException_When_EmptyMatrix() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createDiagonal(new double[]{}));
    }

}