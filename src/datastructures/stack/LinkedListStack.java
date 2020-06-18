package datastructures.stack;

import datastructures.stack.Node;

import java.util.EmptyStackException;

public class LinkedListStack {
    private Node head;
    private int size;

    public LinkedListStack(){
        head = new Node(0);
        size = 0;
    }

    public int pop(){
        if(size <= 0) throw new EmptyStackException();

        int popValue = head.next.data;
        head.next = head.next.next;
        size--;
        return popValue;
    }

    public void push(int val){
        Node temp = head.next;
        Node newNode = new Node(val);
        head.next = newNode;
        newNode.next = temp;
        size++;
    }

    public int peek(){
        if(size <=0 ) throw new EmptyStackException();
        return head.next.data;
    }

    public boolean isEmpty(){
        if(size > 0){
            return false;
        }
        return true;
    }

    public void print(){
        Node curr = head.next;
        String printStack = "top -> ";
        while(curr != null){
            printStack += curr.data + " -> ";
            curr = curr.next;
        }
        printStack += "bottom";
        System.out.println(printStack);
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        System.out.println(stack.isEmpty());
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.print();
    }
}
