import java.util.*;
public class PowerSpectrum {
	private ArrayList<ArrayList<Double>> myPowSpec;
	public PowerSpectrum(ArrayList<ArrayList<Double>> n) {
		myPowSpec = n;
	}
	public double getVal(int time, int coef) {
		return myPowSpec.get(time).get(coef);
	}
	public ArrayList<Double> getTimeCol(int time) {
		return myPowSpec.get(time);
	}
	public double similarity(PowerSpectrum other, int time, String type) {
		if (type.equals("cosine")) {
			ArrayList<Double> first = new ArrayList<Double>();
		}
		return 1;
	}
}