package Heap;

public class MinHeap<T extends Comparable> extends Heap {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    protected void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        //Find min of left and right child elements
        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1)
            smallerIndex = (getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0) ?
                    leftIndex : rightIndex;
        else if (leftIndex != -1)
            smallerIndex = leftIndex;
        else if (rightIndex != -1)
            smallerIndex = rightIndex;

        //if child node doesn't exist; stop sifting down
        if (smallerIndex == -1)
            return;

        //compare smaller child with current index and check if swap/further sifting is needed
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }
    }

    @Override
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }
}
