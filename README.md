# Gaussian Elimination with Scaled Partial Pivoting

## Overview
This program solves a system of linear equations (up to **n = 10**) using **Gaussian elimination with Scaled Partial Pivoting**. It allows users to input equations either:
- **Manually via command line** (by entering each row of coefficients and the constant term)
- **From a text file** containing the augmented coefficient matrix.

## Implementation Details
This program is implemented in **Java** using two main files:
1. **Main.java** - Handles user input, reads matrix from file, and initializes the solver.
2. **SolveMatrix.java** - Performs the Gaussian elimination process with scaled partial pivoting.

## Input Format
The user first chooses how to input the system of equations:
1. **Manually enter the equations**
2. **Provide a file path** containing the augmented coefficient matrix

### Example Input File
For a system of 3 equations:
```
2 3 0 8
-1 2 -1 0
3 0 2 9
```
This represents the system:
- **2x + 3y = 8**
- **-x + 2y - z = 0**
- **3x + 2z = 9**

## Program Output
1. **Displays the scaled ratios at each step**
2. **Indicates the pivot row selected based on the scaled ratio**
3. **Shows the intermediate matrices at each step**
4. **Final computed solution in the format:**
   ```
   x = 1
   y = 2
   z = 3
   ```

## Example Run
### **Option 1: Manually Entering the Matrix**
Upon running the program, the user is prompted to **either create the system manually or load from a file.**

```
Choose input method:
1. Enter equations manually
2. Load from file
```
If the user selects **Option 1**, they enter the matrix coefficients and b values row by row:

```
Enter number of equations: 3
Enter row 1: 2 3 0 8
Enter row 2: -1 2 -1 0
Enter row 3: 3 0 2 9
```
The program then **solves the system, displaying scaled ratios and pivot rows used.**

### **Option 2: Loading a File**
If the user selects **Option 2**, they are prompted to enter the file path:

```
Enter the path to your matrix file: matrix.txt
```
The program reads the file and proceeds with **Gaussian elimination using scaled partial pivoting**, displaying the steps and final solution.

## Java Code Structure
### **Main.java**
- Prompts the user for input method (manual entry or file-based input).
- Reads matrix from user input or file.
- Calls `solveMatrix()` to perform Gaussian elimination.

### **SolveMatrix.java**
- Implements **Gaussian elimination with Scaled Partial Pivoting**.
- Displays intermediate steps, pivot selection, and scaled ratios.
- Computes and prints the final values of unknown variables.

## Notes
- The program ensures numerical stability by selecting the **pivot row based on the scaled ratio**.
- The intermediate steps of the **Gaussian elimination process** are displayed to show matrix transformations.
- The final output presents the computed values of **x, y, z, ...** for the given system.

## Example Output
```
Scaled Ratios:
Row 1: 0.6667
Row 2: 0.5
Row 3: 1.0
Pivot row selected: Row 3

Intermediate Matrix after step 1:
...

Final Solution:
```
```
x = 1
y = 2
z = 3
```

## Usage Instructions
1. **Compile the program**:
   ```bash
   javac Main.java SolveMatrix.java
   ```
2. **Run the program**:
   ```bash
   java Main
   ```
3. **Follow the prompts** to enter data manually or provide a file.
4. **View the step-by-step solution** and final computed results.
