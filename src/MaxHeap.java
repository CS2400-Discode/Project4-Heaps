import java.util.Arrays;
public final class MaxHeap<T extends Comparable<? Super T>> implements MaxHeapInterface<T>
{
private T[] heap;
private int lastIndex;
private int swapIndex;
private boolean initialized = false;
private static final int DEFAULT_CAPACITY = 25;
private static final int MAX_CAPACITY = 10000;

public MaxHeap()
        {
        this(DEFAULT_CAPACITY);
        }

public MaxHeap(int initialCapacity)
        {
        If (initialCapacity < DEFAULT_CAPACITY)
        initialCapacity = DEFAULT_CAPACITY;
        else
        checkCapacity(initialCapacity);

@SupressWarnings(“unchecked”)
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
                heap = tempHeap;
                lastIndex = 0;
                initialized = true;
                }

public sequentialMaxHeap(T[] entries)
        {
        MaxHeap(entries.length);
        assert initialized = true;
        for (int index = 0; index < entries.length; index++)
        {
        add(entries[index]);
        reheap(index + 1);
        }
        }

public optimalMaxHeap(T[] entries)
        {
        MaxHeap(entries.length);
        assert initialized = true;
        for (int index = 0; index < entries.length; index++)
        add(entries[index]);
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        reheap(rootIndex);
        }


public T getMax()
        {
        checkInitialization();
        T root = null;
        if (!isEmpty())
        root = heap[1];
        return root;
        }

public boolean getSize()
        {
        return lastIndex < 1;
        }

public int getSize()
        {
        return lastIndex;
        }

public void clear()
        {
        checkInitialization();
        while (lastIndex > -1)
        {
        heap[lastIndex] = null;
        lastIndex--;
        }
        lastIndex = 0;
        }

public void add(T newEntry)
        {
        checkInitialization();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
        heap[newIndex] = heap[parentIndex];
        newIndex = parentIndex;
        parentIndex = newIndex / 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
        }

public T removeMax()
        {
        checkInitialization();
        T root = null;
        if (!isEmpty())
        {
        root = heap[1];
        heap[1] = heap[lastIndex];
        lastIndex--;
        reheap(1);
        }
        return root;
        }

public T remove(T anEntry)
        {
        checkInitialization();
        boolean found = false;
        int index = 0;
        for (; index < lastIndex; index++)
        {
        if (heap[index].equals(anEntry))
        {
        found = true;
        break;
        }
        }
        if (!found)
        throw new Exception(“Error: entry not found.”);
        for (; index < lastIndex + 1; index++)
        heap[index] = heap[index + 1];
        lastIndex--;
        if (!isEmpty)
        {
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        reheap(rootIndex);
        }
        return anEntry;
        }

private void reheap(int rootIndex)
        {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && (leftChildIndex <= lastIndex))
        {
        int largerChildIndex = leftChildIndex;
        int rightChildIndex = leftChildIndex + 1;
        if ((rightChildIndex <= lastIndex) &&
        heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
        largerChildIndex = rightChildIndex;
        if (orphan.compareTo(heap[largerChildIndex] < 0)
        {
        heap[rootIndex] = heap[largerChildIndex];
        rootIndex = largerChildIndex;
        leftChildIndex = 2 * rootIndex;
        swapIndex++;
        }
        else
        done = true;
        }
        heap[rootIndex] = orphan;
        }


        }
