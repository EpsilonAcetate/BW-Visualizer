import java.io.*;
import java.util.*;

public class BrainwaveClient {
	public static void main(String[] args) {
		CSVReader c = new CSVReader();
		try {
			PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s21.powerspec.csv"));
			PowerSpectrum q = new PowerSpectrum(c.readFile("powerspec/s22.powerspec.csv"));
			System.out.println(p.getVal(10, 11));
			for (int i=0;i<192;i++) {
			//	System.out.print("("+i+",");
			//	System.out.print(p.similarity(q, i, "cosine"));
			//	System.out.print("),");
				System.out.print(q.getVal(3, i));
				System.out.print(", ");
			}
		} catch (FileNotFoundException e) {
			//do nothing
		}
	}
}