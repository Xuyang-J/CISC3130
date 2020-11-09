import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Playlist {

    public static void main(String[] args) throws FileNotFoundException { // main method used to execute other methods
        File file = new File("regional-global-weekly-2020-07-31--2020-08-07.csv");
        BinaryTree a = new BinaryTree();
        String[][] list = new String[200][6]; // 2D array used to store split inputs
        // PrintStream used to output to a file
        PrintStream output = new PrintStream("Song-List-Of-Fiscal-Quarter-2020.txt");
        //String[] files = new String[12]; // string array that will store the name of the input CSV files
        //String[][] bigList = new String[numOfFile * 200][5]; // initializing a list that has size equal to # of csv files * 200(# of tracks in each csv file)
        //for(int i = 0; i < 12; i++) { // this loop fills the big array with all the songs from all the input files by calling the unsortedList method
        splitInput(file, list);
        //unsortedList(bigList, list, 0);
       // }
        //System.out.println(Arrays.toString(list[10]));
        for(int i = 0; i < 200; i++) {
            inserting(a, list, i);
        }
        a.root.preOrder(output);
    }

    // arr[i] = a[i].replace('"', ' '); // Replaces the quotation marks that is present in some artist names
    // arr[i] = arr[i].trim(); // trims the spaces that replaces the quotation marks
    public static void inserting(BinaryTree a, String[][] list, int n) throws FileNotFoundException {
        for (int i = 1; i < 4; i++) {
            if(list[n][i] != null) {
                list[n][i] = list[n][i].replace('"', ' ').trim();
            }
        }
        if((list[n][1] != null && list[n][3] != null && list[n][2] != null)){
            a.insert(list[n][1], Integer.parseInt(list[n][3]), list[n][2]);
        }
    }

    /*public static void unsortedList(String[][] bigList, String[][] list, int inputNum) { // method that take data from string arrays that read from singular csv files
        int n = (inputNum)* 200;
        while(n < 200) {
            for (int i = 0; i < 5; i++) {
                bigList[n][i] = list[n][i];
                System.out.println(bigList[n][i]);
            }
            n++;
        }
    }
    */


    public static void splitInput(File file, String[][] list) throws FileNotFoundException { // takes input from csv files and split it into 2D array
        // which is then printed out to a file in a formatted manner
        Scanner sc = new Scanner(file);
        String temp;
        String[] tempArr;
        int i = 0;
        while (sc.hasNextLine()) { // while loop to read in data from input and store it in 2D array
            temp = sc.nextLine();
            tempArr = temp.split(",");
            //System.out.println(Arrays.toString(tempArr));
            System.arraycopy(tempArr, 0, list[i], 0, tempArr.length );
            i++;
        }
    }
}
