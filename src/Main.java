import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList readFile = new ArrayList();
        Scanner file1 = new Scanner(new File("data_sorted.txt"));

        while (file1.hasNextInt()) {
            readFile.add(file1.nextInt());
        }

        Integer[] data = new Integer[readFile.size()];
        for (int i = 0; i < readFile.size(); i++) {
            data[i] = (int) readFile.get(i);
        }

        MaxHeap heap1 = new MaxHeap(data.length);
        heap1.sequentialMaxHeap(data);

        MaxHeap heap2 = new MaxHeap(data.length);
        heap2.optimalMaxHeap(data);

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Heap built using sequential insertions: " + heap1.getFirst10() + "\n");
            writer.write("Number of swaps in the heap creation: " + heap1.getNumOfSwaps()+ "\n");
            writer.write("Heap after 10 removals: " + heap1.removeFirst10()+ "\n");
            writer.write("\n");
            writer.write("Heap built using optimal insertions: "  + heap2.getFirst10()+ "\n");
            writer.write("Number of swaps in the heap creation: " + heap2.getNumOfSwaps()+ "\n");
            writer.write("Heap after 10 removals: " + heap2.removeFirst10()+ "\n");
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
