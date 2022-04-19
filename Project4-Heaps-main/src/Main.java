import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList readFile = new ArrayList();
        ArrayList readFile2 = new ArrayList();
        Scanner file1 = new Scanner(new File("data_sorted.txt"));
        Scanner file2 = new Scanner(new File("data_random.txt"));

        while (file1.hasNextInt()) {
            readFile.add(file1.nextInt());
        }

        while (file2.hasNextInt()) {
            readFile2.add(file2.nextInt());
        }

        Integer[] data = new Integer[readFile.size()];
        for (int i = 0; i < readFile.size(); i++) {
            data[i] = (int) readFile.get(i);
        }

        Integer[] data2 = new Integer[readFile2.size()];
        for (int i = 0; i < readFile2.size(); i++) {
            data2[i] = (int) readFile2.get(i);
        }

        MaxHeap heap1 = new MaxHeap(data.length);
        heap1.sequentialMaxHeap(data);
        int heap1Swaps = heap1.getNumOfSwaps();

        MaxHeap heap2 = new MaxHeap(data.length);
        heap2.optimalMaxHeap(data);
        int heap2Swaps = heap2.getNumOfSwaps();

        MaxHeap heap3 = new MaxHeap(data2.length);
        heap3.sequentialMaxHeap(data2);
        int heap3Swaps = heap3.getNumOfSwaps();

        MaxHeap heap4 = new MaxHeap(data2.length);
        heap4.optimalMaxHeap(data2);
        int heap4Swaps = heap4.getNumOfSwaps();

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("data_sorted.txt output: " + "\n");
            writer.write("Heap built using sequential insertions: " + heap1.getFirst10() + "\n");
            writer.write("Number of swaps in the heap creation: " + heap1Swaps + "\n");
            writer.write("Heap after 10 removals: " + heap1.removeFirst10()+ "\n");
            writer.write("\n");
            writer.write("Heap built using optimal insertions: "  + heap2.getFirst10() + "\n");
            writer.write("Number of swaps in the heap creation: " + heap2Swaps + "\n");
            writer.write("Heap after 10 removals: " + heap2.removeFirst10() + "\n");
            writer.write("\n");
            writer.write("data_random.txt output: " + "\n");
            writer.write("Heap built using sequential insertions: " + heap3.getFirst10() + "\n");
            writer.write("Number of swaps in the heap creation: " + heap3Swaps + "\n");
            writer.write("Heap after 10 removals: " + heap3.removeFirst10()+ "\n");
            writer.write("\n");
            writer.write("Heap built using optimal insertions: "  + heap4.getFirst10() + "\n");
            writer.write("Number of swaps in the heap creation: " + heap4Swaps + "\n");
            writer.write("Heap after 10 removals: " + heap4.removeFirst10() + "\n");
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
