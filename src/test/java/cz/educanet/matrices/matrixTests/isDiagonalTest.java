package cz.educanet.matrices.matrixTests;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isDiagonalTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Return_True_When_MatrixIsDiagonal() {
        IMatrix identityMatrix = matrixFactory.createIdentity(4);
        IMatrix diagonalMatrix1 = matrixFactory.createDiagonal(new double[]{1, 2, 3, 4});
        IMatrix diagonalMatrix2 = matrixFactory.createDiagonal(new double[]{1, 2, 3});
        IMatrix zeroMatrix = matrixFactory.createZero(2);

        Assertions.assertTrue(identityMatrix.isDiagonal());
        Assertions.assertTrue(diagonalMatrix1.isDiagonal());
        Assertions.assertTrue(diagonalMatrix2.isDiagonal());
        Assertions.assertTrue(zeroMatrix.isDiagonal());
    }

    @Test
    public void should_Return_False_When_MatrixIsNotDiagonal() {
        IMatrix nonSquareMatrix1 = matrixFactory.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        IMatrix nonSquareMatrix2 = matrixFactory.create(new double[][]{{7}, {8}});
        IMatrix squareMatrix = matrixFactory.create(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        Assertions.assertFalse(nonSquareMatrix1.isDiagonal());
        Assertions.assertFalse(nonSquareMatrix2.isDiagonal());
        Assertions.assertFalse(squareMatrix.isDiagonal());
    }

}