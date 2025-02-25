public class SolveMatrix {
    public static void solveMatrix(double[][] matrix) {
        matrix = setUpMatrix(matrix);
        solveVariables(matrix);
    }

    public static void displayMatrix(double[][] matrixPar) {
        for (double[] row : matrixPar) {
            for (double col : row) {
                //System.out.print(col + " ");
                System.out.printf("%.3f ",col);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] setUpMatrix(double[][] matrix) {
        if (matrix[0][0] == 0) {
            double[] temp = new double[matrix[0].length];
            for(int i =0; i < matrix[0].length; i++) {
                temp[i] = matrix[0][i];
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = matrix[1][j];
                matrix[1][j] = temp[j];
            }
        }

        double[][] copyMatrix = copyMatrix(matrix);
        int k = 0;
        for(int i = matrix.length -1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                int r = j + 1 + k;
                int n1 = j + 1 + k;
                int n2 = 0 + k;
                int d1 = 0 + k;
                int d2 = 0 + k;
                int p = 0 + k;

                System.out.printf("The scaled ratio at this intermediate step is: %.3f / %.3f \n", matrix[n1][n2],
                        matrix[d1][d2]);
                System.out.println("The pivot row selected based on this scaled ratio is: ");
                for(int pivot = 0; pivot < matrix[0].length; pivot++) {
                    //System.out.print(matrix[p][pivot] + " ");
                    System.out.printf("%.3f ", matrix[p][pivot]);
                }
                System.out.println();

                for(int row = 0; row < matrix.length; row++) {
                    for(int col = 0; col < matrix[0].length; col++) {
                        copyMatrix[r][col] = matrix[r][col] - (matrix[n1][n2]/matrix[d1][d2])*matrix[p][col];
                    }
                    matrix = copyMatrix(copyMatrix);
                }
            }
            //new transition matrix and display it
            System.out.println();
            System.out.println("And the intermediate matrix is: ");
            displayMatrix(copyMatrix);
            k++;
        }
        return matrix;
    }

    public static void solveVariables(double[][] matrix) {
        double[] variables = new double[matrix.length];
        variables[matrix.length-1] = matrix[matrix.length-1][matrix.length]/matrix[matrix.length-1][matrix.length-1];

        int loops = 1;
        char varChar = 89;
        System.out.println("Therefore the values for the unknown variables are: ");
        System.out.printf("Z = %.3f \n",variables[matrix.length-1]); //debug code

        for (int i = matrix.length - 2; i >= 0; i--) {
            double numConst = matrix[i][matrix.length];
            double denConst = matrix[i][i];
            double numVar = 0;
            int varLoop = matrix.length -1;
            for(int j = 0; j < loops; j++) {
                numVar = numVar - matrix[i][varLoop]*variables[varLoop];
                varLoop--;
            }
            loops++;

            variables[i] = (numConst + numVar)/denConst;

            System.out.printf(("%c = %.3f \n"), varChar, variables[i]); // debug code
            varChar--;
        }
    }

    public static double[][] copyMatrix(double[][] matrix) {
        double[][] copyMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        return copyMatrix;
    }
}
