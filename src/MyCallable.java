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
    	line=line.replace("/", "");
    	line=line.replace("X", "");
    	line=line.replace("-", "");
       String arr[]=line.split(",");
       double[] stat=new double[arr.length];
       double num=0;String id=arr[0];
       for(int i=1;i<arr.length;i++){
    	  if(!arr[i].isEmpty()){
    		  arr[i] = arr[i].replaceAll("\\s","");
        	  num=Double.parseDouble(arr[i]);
        	  stat[i]=num;
       }
    	   	
    	   }
       DoubleAndId did=new DoubleAndId(stat,id);
       return did;
    }
}


