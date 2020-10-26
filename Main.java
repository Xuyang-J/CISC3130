import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException { // main method used to execute other methods
        PrintStream output = new PrintStream("Song-List-Of-Fiscal-Quarter-2020.txt"); // PrintStream used to output to a file
        String[][] list = new String[200][7]; // 2D array used to store split inputs
        String[] bigList = new String[1200];
        String[] files = new String[12]; // string array that will store the name of the input CSV files
        fileNames(files);//method that stores name of CSV input files into files String array
        for(int i = 0; i < 12; i++) { // this loop fills the big array with all the songs from all the input files
            unsortedList(bigList, splitInput(i, files, list), i);
        }
        bigList = alphabeticalSort(bigList);
        String[] stackString = trackHistory(1200,songQueue(bigList)).toArray(); // string array that stores tracks stored in stack
        for(int j = 0; j < 1200; j++) {
            output.println(stackString[j]);
        }
    }

    public static Stack trackHistory(int size, Queue queue) { // moves track from queue to stack
        Stack s = new Stack(1200);
        for(int i = 0; i < size; i++) {
            s.push(queue.peek());
            queue.remove();
        }
        return s;
    }

    public static Queue songQueue(String[] bigList) {
        Queue queue = new Queue(1200);
        for(int i = 0; i < bigList.length; i++) {
            queue.insert(bigList[i]);
        }
        return queue;
    }

    public static void unsortedList(String[] bigList, String[] list, int inputNum) { // method that take data from string arrays that read from singular csv files
        int n = (inputNum)* 200;
        while(n < 1200) {
            for (String s : list) {
                bigList[n] = s;
                n++;
            }
        }
    }


    public static String[] splitInput(int inputNum, String[] files, String[][] list) throws FileNotFoundException { // takes input from csv files and split it into 2D array
                                                                        // which is then printed out to a file in a formatted manner
        File file = new File(files[inputNum]); // path to input file
        Scanner sc = new Scanner(file);
        String temp;
        String[] tempArr;
        String[] list2 = new String[200];
        int i = 0;
        while (sc.hasNextLine()) { // while loop to read in data from input and store it in 2D array
            temp = sc.nextLine();
            tempArr = temp.split(",");
            System.arraycopy(tempArr, 0, list[i], 0, tempArr.length);
            i++;
        }
        for(int j = 0; j < list2.length; j++) {
            list2[j] = list[j][1];
        }

        return list2;
    }

    public static String[] alphabeticalSort(String[] a) { // Sorting the artist name from A-Z
        String[] arr = new String[1200];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i].replace('"', ' '); // Replaces the quotation marks that is present in some artist names
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
        return arr;
    }

    public static void fileNames(String[] fileName) throws FileNotFoundException { // method reads from file containing all CSV file names and returns
        File file = new File("name of CSV files.txt");                     // String array containing the names
        Scanner sc = new Scanner(file);
        for(int i = 0; i < 12; i++) {
            fileName[i] = sc.next();
        }
    }
}
