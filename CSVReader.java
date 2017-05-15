import java.util.*;
import java.io.*;
public class CSVReader {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<ArrayList<Double>> test = new ArrayList<ArrayList<Double>>();
		test = readFile("powerspec/s01.powerspec.csv");
		System.out.println(test.get(2).get(100));
	}
	public static ArrayList<ArrayList<Double>> readFile(String a) throws FileNotFoundException {
		ArrayList<ArrayList<Double>> toreturn = new ArrayList<ArrayList<Double>>();
		File f = new File(a);
		Scanner sc = new Scanner(f);
		String trash = sc.nextLine();
		int count = 0;
		trash = sc.next();
		while (sc.hasNext()) {
			ArrayList<Double> toadd = new ArrayList<Double>();
			while (true) {
				String l = ":(";
				try {l = sc.next();} 
				catch (NoSuchElementException e) {break;}//nothing more to read in entire file
				try {toadd.add(Double.parseDouble(l.substring(0,l.length()-1)));} 
				catch (NumberFormatException e) {//end of line
					toreturn.add(toadd);
					break;
				}
			}			
		}
		return toreturn;
	}
}