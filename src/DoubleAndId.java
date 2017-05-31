/**
 * This class is defined to hold the return value of the callable.
 * 
 */

/**
 * @author mariachowdhury
 *
 */
public class DoubleAndId {
	double[] a;
	String id;
	public DoubleAndId(double[]a,String id){
		this.a=a;
		this.id=id;
	}
	public double[] getArray(){
		return a;
	}
	public String getId(){
		return id;
	}

}
