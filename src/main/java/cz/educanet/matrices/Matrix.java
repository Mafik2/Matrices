package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        return null;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(Number scalar) {
        double[][] result = new double[getRows()][getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                result[i][j] = scalar.doubleValue() * rawArray[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] result = new double[getRows()][getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                result[i][j] = rawArray[i][j] + matrix.get(i, j);
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix transpose() {
        return null;
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        return 0;
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isSquare() {
        return getRows() == getColumns();
    }

    @Override
    public boolean isDiagonal() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < rawArray.length; i++) {
            for (int j = 0; j < rawArray[i].length; j++) {
                if (i != j && rawArray[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Number getTrace() {
        return null;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
