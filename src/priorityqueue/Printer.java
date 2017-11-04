package priorityqueue;

/**
 *
 * @author jcd4912
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Printer
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {    
        BufferedReader lbr = new BufferedReader(new FileReader("print.txt"));
        String line;
        BinaryHeap<PrintJob> pq = new BinaryHeap<>();

        while ((line = lbr.readLine()) != null){
             System.out.println(line);
             String [] var= line.split("\t");
             if(var[3].equals("I"))
                pq.insert(new PrintJob(Integer.parseInt(var[0]),var[1],Integer.parseInt(var[2])));
             else
                 pq.insert(new OutsidePrintJob(Integer.parseInt(var[0]),var[1],Integer.parseInt(var[2])));
        }
        System.out.println("Jobs added");
        while(!pq.isEmpty()){
            System.out.println("Jobs removed");
             pq.deleteMin().print();
        }
    }
}
