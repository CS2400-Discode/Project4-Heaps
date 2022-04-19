import java.util.Arrays;

public final class MaxHeap<T extends Comparable<? super T>>
             implements MaxHeapInterface<T>
{
   private T[] heap;
   private int lastIndex;
   private boolean initialized = false;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;
   private static int numOfSwaps = 0;
   
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY);
   }
   
   public MaxHeap(int initialCapacity)
   {
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else
         checkCapacity(initialCapacity);

      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      initialized = true;
   }

   public T getMax()
   {
      checkInitialization();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   }

   public boolean isEmpty()
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

   private void reheap(int rootIndex) {
      boolean done = false;
      T orphan = heap[rootIndex];
      int leftChildIndex = 2 * rootIndex;

      while (!done && (leftChildIndex <= lastIndex)) {
         int largerChildIndex = leftChildIndex;
         int rightChildIndex = leftChildIndex + 1;

         if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
         {
            largerChildIndex = rightChildIndex;
         }

         if (orphan.compareTo(heap[largerChildIndex]) < 0)
         {
            heap[rootIndex] = heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex;
            numOfSwaps++;
         }
         else
         {
            done = true;
         }
      }
      heap[rootIndex] = orphan;
   }

   public T remove(T anEntry) {
      checkInitialization();
      boolean found = false;
      for (int index = 0; index < lastIndex; index++)
      {
         if (heap[index].equals(anEntry))
         {
            found = true;
            break;
         }
      }
      if (!found)
         throw new IllegalStateException("Error: entry not found.");

      for (int index = 0; index < lastIndex + 1; index++)
         heap[index] = heap[index + 1];
      lastIndex--;
      if (!isEmpty())
      {
         for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
      }
      return anEntry;
   }

   public void optimalMaxHeap(T[] entries) {
      numOfSwaps = 0;
      lastIndex = entries.length;
      assert initialized = true;

      for (int index = 0; index < entries.length; index++)
         heap[index + 1] = entries[index];

      for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
         reheap(rootIndex);
   }

   public void sequentialMaxHeap(T[] entries) {
      numOfSwaps = 0;
      assert initialized = true;
      for (int index = 0; index < entries.length; index++)
      {
         add(entries[index]);
      }
      reheap(1);
   }

   private void checkCapacity(int initialCapacity) {
      if (initialCapacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a heap over the capacity of " + MAX_CAPACITY);
   }

   private void checkInitialization() {
      if (!initialized)
         throw new SecurityException("ArrayBag object is corrupt.");
   }

   public int getNumOfSwaps(){
      int swaps = numOfSwaps;
      return swaps;
   }

   public String getFirst10()
   {
      String output = "";
      for(int i=1; i <10; i ++)
      {
         output += heap[i] + ",";
//         System.out.print(heap[i] + ",");
      }
      output += "...";
      return output;
   }

   public String removeFirst10()
   {
      for(int i = 0; i < 10; i++)
      {
         removeMax();
      }

      String output = getFirst10();
      return output;
   }
}
