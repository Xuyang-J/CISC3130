import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException { // main method used to execute the main code.
        splitInput();

    }
    public static void splitInput() throws FileNotFoundException { // main code 
        PrintStream output = new PrintStream("Artists-WeekOf09082020.txt");// PrintStream setup for outputting to a file.
        String[][] list = new String[189][7]; // initializing the nested array that will be used to store the data
        File file = new File("streams.csv");// file setup for scanner to read in
        Scanner sc = new Scanner(file); // scanner setup
        String temp = ""; // will be used to store lines of string from input
        String[] tempArr; // will be used to store individual lines of data from split of temp.
        int i = 0;
        while(sc.hasNextLine()) { //while + for loop to assign data read from file into nested array
            temp = sc.nextLine();
            tempArr = temp.split(",");
            for(int j = 0; j < tempArr.length; j++) {
                list[i][j] = tempArr[j];
            }
            i++;
        }
        output.printf("%-13s%-38s%-40s%-32s%-32s%n","Ranking" ,"Song Name" ,"Artists" ,"Streams","URL"); //code for outputting and formatting to a txt file.
        for(int j = 0; j < 189; j++) {
            output.printf("%-13s%-42s%-35s%-35s%-40s%n",list[j][0],list[j][1],list[j][2],list[j][3],list[j][4]);

        }

    }
}
