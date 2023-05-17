public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows, int ncols) {
        this.nrows = nrows;
        this.ncols = ncols;
        matrix = new int[nrows][ncols];
    }

    public Matrix(int[][] arr) {
        this.nrows = arr.length;
        this.ncols = arr[0].length;
        matrix = arr;
    }

    public Matrix transpose() {
        Matrix tempMatrix = new Matrix(ncols, nrows);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tempMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        return tempMatrix;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output += matrix[i][j];
            }
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args){
        int[][] myArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix myMatrix = new Matrix(myArray);
        System.out.println(myMatrix);
        System.out.println(myMatrix.transpose());
    }
}
