import java.io.*;
import java.util.*;
public class GradeCalculator {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream("CISC 3130 Grade Fall Semester 2020.txt");
        int[] counts = new int[4];
        int[][] grades = new int[4][8]; // 2D array to store grades from different assignments
        int[] sums = new int[4]; // array used to store average of the grades
        scanGrade(grades, counts);
        sumCalc(grades, sums);
        double totalGrade = totalGradeCalculate(sums, counts);
        outputting(out, sums, totalGrade);

    }

    public static double totalGradeCalculate(int[] sums, int[] counts) {
        double[] multiplier = new double[] {0.44, 0.16, 0.20, 0.20}; // This is the maximum possible grade of the corresponding grades,
                                                                        // not necessarily used, just for display
        return (sums[0]) + (sums[1]) + (((double)(sums[2]) / counts[2]) * .20) + (0.20 * sums[3]);
    }

    public static void outputting(PrintStream out, int[] sums, double totalGrade) {
        out.println("Practice Problem Grade: " + sums[0]);
        out.println("Lab Grade: " + sums[1]);
        out.println("Midterm Grade: " + sums[2]);
        out.println("Final Exam Grade: " + sums[3]);
        out.printf("%s%.2f" ,"Final Grade on Transcript: ", totalGrade);
    }

    public static void scanGrade(int[][] grades, int[] counts) throws FileNotFoundException {
        String[] fileName = new String[4]; // array to store address of txt files containing the grades
        fileNames(fileName); // fills up the fileName array with addresses of txt files containing the grades
        for (int i = 0; i < grades.length; i++ ) { // for loop looping through the rows of the 2D array
            int j = 0; // iterative variable used to loop through columns of 2D array
            Scanner sc = new Scanner(new File(fileName[i])); // scanner object used to scan through each of the txt files for grades
            while (sc.hasNext()) { // while loop to loop through the columns of 2D array
                grades[i][j] = sc.nextInt();
                j++;
            }
            counts[i] = j;
        }
    }

    public static void sumCalc(int[][] grades, int[] sums){ // calculates the average grade for each assignment section
        for(int i = 0; i < grades.length; i++) {
            int sum = 0;
            for(int j = 0; j < grades[i].length; j++) {
                 sum += grades[i][j];
            }
            sums[i] = sum;
            //average[i] = sum / counts[i]; // calculates average by dividing sum using its corresponding number of appearances
        }                                   // kept track of using parallel array
    }

    public static void fileNames(String[] fileName) throws FileNotFoundException { // method reads from file containing all txt file names and returns
        Scanner sc = new Scanner(new File("name of Grades files.txt" ));
        for(int i = 0; i < 4; i++) {
            fileName[i] = sc.next();
        }
    }
}
