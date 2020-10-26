import java.util.Arrays;

public class Stack { // Part of code sourced from Derek Banas
    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;
    Stack(int size) {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {
        if(topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        }
        else{
            System.out.println("Stack is Full");
        }
    }

    public String pop(){
        if(topOfStack >= 0){
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        }
        else{
            return "-1";
        }
    }

    public String[] toArray() {
        return stackArray;
    }
}
