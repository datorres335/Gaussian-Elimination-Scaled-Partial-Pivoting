import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SolveMatrix solveMatrix = new SolveMatrix();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to type in the coefficients for a set of linear matrix equations (option " +
                "1), \nor input a file path to an existing matrix .txt file (option 2)? \nType 1 for option 1 or 2 " +
                "for " +
                "option 2: ");
        String userOption = scanner.nextLine();
        double[][] userMatrix;

        //let user create matrix for option 1
        if (Objects.equals(userOption, "1")) {
            userMatrix = createUserMatrix(scanner);
            System.out.println("Here is your matrix to be solved: ");
            solveMatrix.displayMatrix(userMatrix);
        } else {
            // get user file path for option 2
            System.out.print("Enter a file name that contains an augmented coefficient matrix: ");
            String userFileString = scanner.nextLine();
            scanner.close();
            userMatrix = convertFile(userFileString);
            System.out.println();
        }


        solveMatrix.solveMatrix(userMatrix);
    }//psvm

    public static double[][] convertFile(String userInputPar) {
        String backslash = "\\\\"; //four backslashes are needed to represent a single backslash in a regular expression
        String doubleBackslash = "\\\\\\\\";
        String updatedURL = userInputPar.replaceAll(backslash, doubleBackslash);

        ArrayList<String> matrixLineArr;
        ArrayList<ArrayList<Integer>> matrixAL;
        double[][] matrix;
        try (BufferedReader br = new BufferedReader(new FileReader(updatedURL))) {
            String line;
            matrixLineArr = new ArrayList<>();
            System.out.println("Here is your matrix to be solved: ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                matrixLineArr.add(line);
            }

            //converting string file into an integer 2x2 array //CODE IS SUCCESSFUL
            matrixAL = new ArrayList<>();
            for (String s : matrixLineArr) {
                ArrayList<Integer> row = new ArrayList<>();
                String[] tempStringArr = s.split("\\s+");

                for (String value : tempStringArr) {
                    int tempInt = Integer.parseInt(value);
                    row.add(tempInt);
                }
                matrixAL.add(row);
            }
            matrix = new double[matrixAL.size()][matrixAL.get(0).size()];
            for (int i = 0; i < matrixAL.size(); i++) {
                for (int j = 0; j < matrixAL.get(0).size(); j++) {
                    matrix[i][j] = matrixAL.get(i).get(j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            matrixAL =null;
            matrix = null;
        }
        return matrix;
    }

    public static double[][] createUserMatrix(Scanner scanner) {
        System.out.println("How many equations would you like to see in this square matrix?");
        int numOfEquations = Integer.parseInt(scanner.nextLine());
        double [][] userMatrix = new double[numOfEquations][numOfEquations+1];
        for (int i = 0; i < numOfEquations; i++) {
            for (int j =0; j < numOfEquations+1; j++) {
                if (j < numOfEquations) {
                    System.out.println("Enter the coefficient value for the matrix position a" + i + j);
                    userMatrix[i][j] = Integer.parseInt(scanner.nextLine());
                } else {
                    System.out.println("Enter the b value for row " + i);
                    userMatrix[i][j] = Integer.parseInt(scanner.nextLine());
                }
            }
        }
        scanner.close();
        System.out.println();
        return userMatrix;
    }
}
