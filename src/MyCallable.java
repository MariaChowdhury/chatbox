import java.util.concurrent.Callable;

/**
 * 
 */


/**
 * @author mariachowdhury
 *
 */
public class MyCallable implements Callable<DoubleAndId> {
    private String line;

    MyCallable(String line) {
        this.line=line;
    }

    @Override
    public DoubleAndId call() throws Exception {
    	line=line.replace("/", "-1");
    	line=line.replace("X", "10");
    	line=line.replace("-", "0");
       String arr[]=line.split(",");
       double[] stat=new double[arr.length];
       double num=0;String id=arr[0];
       for(int i=1;i<arr.length;i++){
    		  arr[i] = arr[i].replaceAll("\\s","");
        	  num=Double.parseDouble(arr[i]);
        	  stat[i]=num;
    	   	
    	   }
       DoubleAndId did=new DoubleAndId(stat,id);
       return did;
    }
}


