package datastructures.dynamicarray;

public class DynamicArray {
    private int INITIAL_ARRAY_SIZE = 8;
    private int[] a = new int[INITIAL_ARRAY_SIZE];
    private int size = 0;

    // Returns current size of array
    public int size(){
        return this.size;
    }

    // Returns number of items array can hold
    public int capacity(){
        return this.a.length;
    }

    public boolean isEmpty(){
        if(this.size == 0) return false;
        return true;
    }

    // Finds item at given index
    public int at(int index){
        if(index > this.size) {
            System.out.println("Index out of bounds");
            return -1; // index out of bounds
        }
        return this.a[index];
    }

    // Adds item at end of array
    public void push(int num){
        resize();
        a[this.size] = num;
        this.size++;
    }

    public void insert(int index, int num){
        resize();
        // TODO: What if index is bigger than current size of array?
        for(int i = this.size -1; i >= index;i--){
            this.a[i + 1] = this.a[i];
        }
        this.a[index] = num;
        this.size++;
    }

    public void prepend(int num){
        resize();
        for(int i = this.size-1; i >= 0; i--){
            this.a[i + 1] = this.a[i];
        }
        this.a[0] = num;
        this.size++;
    }

    // Removes last element
    public int pop(){
        int endItem = a[this.size-1];
        a[this.size - 1] = 0;
        this.size--;
        resize();
        return endItem;
    }

    public void delete(int index){
        for(int i = index; i < this.size - 1; i++){
            this.a[i] = this.a[i+1];
        }
        this.a[this.size-1] = 0;
        this.size--;
    }

    public void remove(int num){
        for(int i = 0; i < this.size; i++){
            if(this.a[i] == num){
                delete(i);
            }
        }
    }

    public int find(int num){
        for(int i = 0; i < this.size; i++){
            if(this.a[i] == num) return i;
        }
        return -1;
    }

    private void resize(){
        if(this.size == capacity()) {
            int[] oldArray = this.a;
            this.a = new int[capacity() * 2];
            for (int i = 0; i < oldArray.length; i++) {
                this.a[i] = oldArray[i];
            }
        } else if(this.size == capacity()/4 && this.size > INITIAL_ARRAY_SIZE){
            int[] oldArray = this.a;
            this.a = new int[capacity()/2];
            for(int i = 0; i < this.size; i++){
                this.a[i] = oldArray[i];
            }
        }
    }

    public void print(){
        String printedArray = "[";
        for(int i = 0; i < this.size; i++){
            printedArray = printedArray + a[i] + ", ";
        }
        printedArray = printedArray + " ]";
        System.out.println(printedArray);
    }

    public static void main(String[] args){
        DynamicArray arr = new DynamicArray();
        arr.push(2);
        arr.push(1);
        arr.push(3);
        arr.prepend(4);
        arr.print();
        System.out.println(arr.capacity());
    }
}
