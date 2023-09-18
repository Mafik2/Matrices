package cz.educanet.matrices.matrixTests;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isSquareMatrix {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Return_True_WhenMatrixIsSquare() {
        double[][] squareData = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        IMatrix squareMatrix = matrixFactory.create(squareData);
        Assertions.assertTrue(squareMatrix.isSquare());
    }

    @Test
    public void should_Return_False_WhenMatrixIsNotSquare() {
        double[][] nonSquareData = {{1, 2, 3}, {4, 5, 6}};
        IMatrix nonSquareMatrix = matrixFactory.create(nonSquareData);

    }
}