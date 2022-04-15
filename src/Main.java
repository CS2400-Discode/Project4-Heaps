import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
       ArrayList readFile = new ArrayList();

        Scanner file1 = new Scanner(new File("data_random.txt"));

        while (file1.hasNextInt()) {            //reads data in file to ArrayList
            readFile.add(file1.nextInt());
        }

        Integer[] data = new Integer[readFile.size()];

        for (int i = 0; i < readFile.size(); i++){          //copies contents from Arraylist to normal array
            data[i] = (int) readFile.get(i);
        }

        MaxHeap heap1 = new MaxHeap();
        heap1.sequentialMaxHeap(data);
    }
}
