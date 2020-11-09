import java.io.FileNotFoundException;

// Code inspired by Joe James
public class BinaryTree {
    Node root;

    public boolean find(String song, Node a) {
        if(root == null) {
            return false;
        }
        else
            return root.find(song, a);
    }
    public boolean insert(String song, int count, String artistName) {
        if(root == null) {
            root = new Node(song, count, artistName);
            return true;
        }else
            return root.insert(song, count, artistName);
    }

    public String toString() {
        return "Song Title: " + root.key; //+ " \n# of Stream: " + root.count + "\nName of Artist: " + root.artistName;
    }

     /*public void insert(String key, int count, String name, int artistAverage) {
        // new Node and initialize it
        Node newNode = new Node(key, count, name, artistAverage);
        // set new root if there is no root
        if (root == null) {
            root = newNode;
        } else {
            // set the root node that we start traversing the tree from
            Node focusNode = root;
            // Future parent for our new Node
            Node parent;
            while (true) {
                parent = focusNode;
                // Check if the new node should go on the left side
                // also check if song at node is the same
                if(key.equalsIgnoreCase(focusNode.key)) {
                    focusNode.count += count;
                }else if(focusNode.artistName.equalsIgnoreCase(name)) {
                    focusNode.artistAverage += count;
                }
                else {

                    if (key.charAt(0) < focusNode.key.charAt(0)) {
                        // Switch focus to the left child
                        focusNode = focusNode.left;
                        // If the left child has no children
                        if (focusNode == null) {
                            // then place the new node on the left of it
                            parent.left = newNode;
                            return; // All Done so return to exit loop
                        }
                    } else { // If we get here put the node on the right
                        focusNode = focusNode.right;
                        // If the right child has no children
                        if (focusNode == null) {
                            // then place the new node on the right of it
                            parent.right = newNode;
                            return; // All Done so return to exit loop
                        }
                    }
                }
            }
        }
    }
    */

}


