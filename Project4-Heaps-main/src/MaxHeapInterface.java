public interface MaxHeapInterface<T extends Comparable<? super T>>
{
    public void add(T newEntry);
    public void sequentialMaxHeap(T[] entries);
    public void optimalMaxHeap(T[] entries);
    public T remove(T anEntry);
    public T removeMax();
    public T getMax();
    public boolean isEmpty();
    public int getSize();
    public void clear();
}
