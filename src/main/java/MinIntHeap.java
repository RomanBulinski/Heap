import java.util.Arrays;

public class MinIntHeap {

    private int capacity;
    private int size = 0;
    int[] items;

    public MinIntHeap(int capacity){
        this.capacity = capacity;
        items = new int[capacity];
    }


    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childrenIndex) {
        return (childrenIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRIghtChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureEXtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalMonitorStateException();
        return items[0];
    }


    public int poll() {
        if (size == 0) throw new IllegalMonitorStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifDown();
        return item;
    }

    public void add(int item) {
        ensureEXtraCapacity();
        items[size] = item;
        size++;
        heapifUp();
    }


    private void heapifUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRIghtChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }


    }


    public String toString() {
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            temp = temp + items[i] + " ";
        }
        return temp;
    }
}
