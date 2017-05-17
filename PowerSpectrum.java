import java.util.*;
public class PowerSpectrum {
	private ArrayList<ArrayList<Double>> myPowSpec;

	public PowerSpectrum(ArrayList<ArrayList<Double>> n) { //constructor: sets myPowSpec to the passed 2d arraylist
		myPowSpec = n;
	}
	public double getVal(int time, int coef) { //gets a value
		return myPowSpec.get(time).get(coef);
	}
	public ArrayList<Double> getTimeCol(int time) { //gets a single time snapshot vector
		return myPowSpec.get(time);
	}
	public double similarity(PowerSpectrum other, int time, String type) { //returns similarity of a certain type at a certain time
		if (type.equals("cosine")) {
			ArrayList<Double> first = new ArrayList<Double>();
			ArrayList<Double> second = new ArrayList<Double>();
			first = this.getTimeCol(time);
			second = other.getTimeCol(time);
			return dotProduct(first, second) / (vectMagnitude(first) * vectMagnitude(second));
		}
		return 0;
	}
	private double dotProduct(ArrayList<Double> a, ArrayList<Double> b) { //vector operation used for cosine similarity
		if (a.size() == b.size()) {
			double total = 0;
			for (int i=0;i<a.size();i++) {
				total += a.get(i) * b.get(i);
			}
			return total;
		} 
		return 0;
	}
	private double vectMagnitude(ArrayList<Double> a) { //vector operation used for cosine similarity
		double total = 1;
		for (int i=0;i<a.size();i++) {
			total += a.get(i) * a.get(i);
		}
		return Math.sqrt(total);
	}
}