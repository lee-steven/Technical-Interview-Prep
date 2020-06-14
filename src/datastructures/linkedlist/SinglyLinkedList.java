package datastructures.linkedlist;

public class SinglyLinkedList {
    // TODO: Change to generics
    private Node head;
    private int size;

    public SinglyLinkedList(){
        head = new Node(0);
        size = 0;
    }

    public void push_front(int data){
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public int pop_front(){
        int poppedItem = head.next.data;
        head.next = head.next.next;
        size--;
        return poppedItem;
    }

    public void push_back(int data){
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        Node newNode = new Node(data);
        currNode.next= newNode;
        size++;
    }

    public int pop_back(){
        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        int poppedItem = currNode.next.data;
        currNode.next = null;
        size--;
        return poppedItem;
    }

    public int front(){
        return head.next.data;
    }

    public int back(){
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        return currNode.data;
    }

    public int value_at(int index){
        int counter = 0;
        Node currNode = head.next;
        while(currNode != null){
            if(counter == index){
                return currNode.data;
            }
            currNode = currNode.next;
            counter++;
        }
        return -1;
    }

    public boolean empty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void print(){
        Node node = head;
        String printedList = "";
        while(node != null){
            printedList = printedList + node.data + " -> ";
            node = node.next;
        }
        printedList = printedList + "null";
        System.out.println(printedList);
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.push_front(1);
        linkedList.push_front(4);
        linkedList.push_back(3);
        linkedList.push_back(2);
        linkedList.print();
        System.out.println("VALUE AT : " + linkedList.value_at(4));
        System.out.println("SIZE OF LINKED LIST: " + linkedList.size());
    }
}
