import java.io.*;
import java.util.*;

public class BrainwaveClient {
	public static void main(String[] args) {
		CSVReader c = new CSVReader();
		try {
			PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s01.powerspec.csv"));
			System.out.println(p.getVal(10, 11));
		} catch (FileNotFoundException e) {
			//do nothing
		}
	}
}