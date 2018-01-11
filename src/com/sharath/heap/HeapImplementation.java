package com.sharath.heap;

/**
 * A heap is actually implemented as an array.
 * 
 * @author sharath
 */
public class HeapImplementation
{
    private static int[] heap = new int[20];
    static int heapSize = 0;

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        heap[0] = 1;
        heap[1] = 5;
        heap[2] = 6;
        heap[3] = 8;
        heap[4] = 12;
        heap[5] = 14;
        heap[6] = 16;
        heapSize = 7;
        // building max heap - this should also sort the elements in descending
        // order.
        buildHeap();
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + ", ");
        System.out.println();
        increaseValueOfKey(5, 100);
        System.out.println("New heap");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + ", ");
        System.out.println();
        System.out.println("deleting max element: " + deleteMax());
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + ", ");
    }

    private static void buildHeap()
    {
        int indexOfElementJustBeforeFirstLeaf = (int) Math.floor(heapSize / 2.0) - 1;
        while (indexOfElementJustBeforeFirstLeaf >= 0)
        {
            maxHeapify(indexOfElementJustBeforeFirstLeaf);
            indexOfElementJustBeforeFirstLeaf--;
        }
    }

    private static void maxHeapify(int i)
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left >= heapSize && right >= heapSize)
            return;
        int largest = i;
        if (heap[left] > heap[largest])
            largest = left;
        if (heap[right] > heap[largest])
            largest = right;
        if (largest != i)
        {
            int temp = heap[largest];
            heap[largest] = heap[i];
            heap[i] = temp;
        }
        if (largest == i)
            return;
        maxHeapify(largest);
    }

    private static int deleteMax()
    {
        if (heapSize < 1)
        {
            System.out.println("cannot delete since heap is already empty");
            return 0;
        }
        int max = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        maxHeapify(0);
        return max;
    }

    private static void increaseValueOfKey(int index, int newVal)
    {
        heap[index] = newVal;
        int parent = ((index + 1) / 2) - 1;
        while (parent >= 0)
        {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            if (parent == 0)
                return;
            parent = ((parent + 1) / 2) - 1;
        }
    }
}
