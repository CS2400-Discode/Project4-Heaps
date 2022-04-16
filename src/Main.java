import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList readFile = new ArrayList();

        Scanner file1 = new Scanner(new File("data_random.txt"));

        while (file1.hasNextInt()) {            //reads data in file to ArrayList
            readFile.add(file1.nextInt());
        }

        Integer[] data = new Integer[readFile.size()];

        for (int i = 0; i < readFile.size(); i++) {          //copies contents from Arraylist to normal array
            data[i] = (int) readFile.get(i);
        }

        MaxHeap heap1 = new MaxHeap(data.length);
        heap1.sequentialMaxHeap(data);

//        try {
//            FileWriter writer = new FileWriter("output.txt");
//            writer.write("Heap built using sequential insertions: \n");
//            writer.write("Number of swaps in the heap creation: \n");
//            writer.write("Heap after 10 removals: \n");
//            writer.write("\n");
//            writer.write("Heap built using sequential insertions: \n");
//            writer.write("Number of swaps in the heap creation: \n");
//            writer.write("Heap after 10 removals: \n");
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
