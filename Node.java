import java.io.FileNotFoundException;
import java.io.PrintStream;

// Code inspired by Joe James
public class Node {
    public String key, artistName;
    public int count;
    public Node left, right;

    public Node(String song, int count, String artistName)  {
        key = song;
        this.count = count;
        this.artistName = artistName;
        left = right = null;
    }
    public boolean insert(String song, int count, String artistName)  {
        boolean added = false;
        if(song.compareToIgnoreCase(this.key) < 0) {
                if(this.left == null) {
                    this.left = new Node(song, count, artistName);
                    return true;
                }
                else
                    added = this.left.insert(song, count, artistName);
        }
        else if (song.compareToIgnoreCase(this.key) > 0) {
            if (this.right == null) {
                this.right = new Node(song, count, artistName);
                return true;
            }
            else
                added = this.right.insert(song, count, artistName);
        }
        return added;
    }

    public boolean find(String song, Node a) {
        boolean found = false;
        if (a == null) {
            return false;
        } else {
            if (song.equals(a.key)) {
                return true;
            } else if (song.charAt(0) < a.key.charAt(0) && a.left != null) {
                found = a.left.find(song, a);
            } else if (song.charAt(0) > a.key.charAt(0) && a.left != null) {
                found = a.right.find(song, a);
            }
            return found;
        }
    }

    public void preOrder(PrintStream output){
        output.println(this.key);
        //System.out.println(this.count);
       // System.out.println(this.artistName);
        if(this.left != null) {
            this.left.preOrder(output);
        }else if(this.right != null){
            this.right.preOrder(output);
        }
    }
}
