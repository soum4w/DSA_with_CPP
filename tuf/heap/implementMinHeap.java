package heap;

public class implementMinHeap {
}
class Solution {
    private int[] heap;
    private int size;
    private int capacity;

    private void resize(){
        if(size==capacity){
            capacity*=2;
            int[] newHeap = new int[capacity];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }

    private void heapifyUp(int index){
        while(index>0){
            int parent = (index-1)/2;
            if(heap[parent]<=heap[index]){
                break;
            }
            //swap
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            index = parent;
        }
    }

    private void heapifyDown(int index){
        while(true){
            int smallest = index;
            int left = index*2+1;
            int right = index*2+2;
            if(left<size && heap[smallest]>heap[left]) smallest = left;
            if(right<size && heap[smallest]>heap[right]) smallest = right;
            if(smallest==index) break;
            //swap
            int temp = heap[smallest];
            heap[smallest]=heap[index];
            heap[index] = temp;
            index = smallest;
        }
    }

    public void initializeHeap() {
        capacity = 1000;
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int key) {
        resize();
        heap[size]=key;
        heapifyUp(size);
        size++;
    }

    public void changeKey(int index, int newVal) {
        if(index<0 || index>=size) return;
        int oldVal = heap[index];
        heap[index]=newVal;
        if(newVal>oldVal) heapifyDown(index);
        if(newVal<oldVal) heapifyUp(index);
    }

    public void extractMin() {
        if(size==0) return;
        heap[0] = heap[size-1];
        size--;
        if(size>0) heapifyDown(0);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getMin() {
        if(size==0) return -1;
        return heap[0];
    }

    public int heapSize() {
        return size;
    }
}