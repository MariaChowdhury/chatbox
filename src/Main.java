import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 
 * @author mariachowdhury
 *
 */
public class Main {
    private static final int NTHREDS = 5;

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    	String myFile="/Users/mariachowdhury/Documents/data.csv";
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        Scanner sc=new Scanner(new FileReader(myFile));
        ArrayList<Future<DoubleAndId>> list = new ArrayList<Future<DoubleAndId>>();
        while(sc.hasNext()){
        	String line=sc.nextLine();
        	if(!line.isEmpty()){
        		Callable<DoubleAndId> worker = new MyCallable(line);
                Future<DoubleAndId> submit = executor.submit(worker);
                list.add(submit);
        	}
        }
        sc.close();
        
        for (Future<DoubleAndId> future : list) {
            try {
            	DoubleAndId stat=future.get();
               Statistics statistics=new Statistics(stat.getArray());
               System.out.println("Id:"+stat.getId());
               System.out.println("Mean is: "+statistics.getMean());
               System.out.println("Median is: "+statistics.median());
               System.out.println("Standard Deviation is: "+statistics.getStdDev());
               System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(list.size());
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
    }
}