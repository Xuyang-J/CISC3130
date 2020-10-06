import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException { // main method used to execute other methods
        splitInput();

    }

    public static void splitInput() throws FileNotFoundException { // takes input from csv file and split it into 2D array
                                                                        // which is then printed out in a formatted manner
        PrintStream output = new PrintStream("Artists-WeekOf10-01-2020.txt"); // PrintStream used to output to a file
        String[][] list = new String[199][6]; // 2D array used to store split inputs
        File file = new File("input.csv"); // path to input file
        Scanner sc = new Scanner(file);
        String temp;
        String[] tempArr;
        int i = 0;
        while (sc.hasNextLine()) { // while loop to read in data from input and store it in 2D array
            temp = sc.nextLine();
            tempArr = temp.split(",");
            System.arraycopy(tempArr, 0, list[i], 0, tempArr.length);
            i++;
        }
        Iterator it = alphabeticalSort(list).iterator(); //iterator object that iterates through the Linked List to output
        int num = 0;
        while (it.hasNext()) {
            output.printf("%-10s%s%n", num + 1, it.next());
            num++;
        }
    }

    public static LinkedList alphabeticalSort(String[][] a) { // Sorting the artist name from A-Z and feeding it to a linked list
        String[] arr = new String[199];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i][2].replace('"', ' '); // Replaces the quotation marks that is present in some artist names
            arr[i] = arr[i].trim(); // trims the spaces that replaces the quotation marks
        }
        String temp;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int x = 0; x < arr.length - 1; x++) {
                if (arr[x].substring(0, 1).compareToIgnoreCase(arr[x + 1].substring(0, 1)) > 0) { //sorts the names of the artist from A-Z
                    temp = arr[x];                                                      // through bubble sort
                    arr[x] = arr[x + 1];
                    arr[x + 1] = temp;
                }
            }
        }
        return new LinkedList(Arrays.asList(arr));
    }
}
