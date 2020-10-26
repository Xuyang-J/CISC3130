public class Queue {  // Part of code sourced from Derek Banas
    private String[] queueArray;
    private int queueSize;
    private int front, rear, numberOfItems = 0;
    Queue(int size) {
        queueSize = size;
        queueArray = new String[size];
    }

    public void insert(String input) {
        if(numberOfItems + 1 <= queueSize) {
            queueArray[rear] = input;
            rear++;
            numberOfItems++;
        }
        else {
            System.out.println("Queue is Full");
        }
    }

    public void remove(){ //removes the first item in the queue
        if(numberOfItems > 0) { // to prevent empty array error
            queueArray[front] = "-1"; // -1 so the data is considered removed by the system
            front++;
            numberOfItems--;
        }
    }

    public String peek() {
        return queueArray[front];
    }
}
