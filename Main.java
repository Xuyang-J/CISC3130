import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        splitInput();

    }
    public static void splitInput() throws FileNotFoundException {
        PrintStream output = new PrintStream("output.txt");
        String[][] list = new String[189][7];
        File file = new File("streams.csv");
        Scanner sc = new Scanner(file);
        String temp = "";
        String[] tempArr;
        int i = 0;
        while(sc.hasNextLine()) {
            temp = sc.nextLine();
            tempArr = temp.split(",");
            for(int j = 0; j < tempArr.length; j++) {
                list[i][j] = tempArr[j];
            }
            i++;
        }
        output.printf("%-13s%-38s%-40s%-32s%n","Ranking" ,"Song Name" ,"Artists" ,"Streams");
        for(int j = 0; j < 189; j++) {
            output.printf("%-13s%-42s%-35s%-35s%n",list[j][0],list[j][1],list[j][2],list[j][3]);

        }

    }
}
