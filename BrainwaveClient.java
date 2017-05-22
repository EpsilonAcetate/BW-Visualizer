import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BrainwaveClient extends Application{
    @Override
         public void start(Stage primaryStage) throws IOException {
            /*generic container class*/Parent root = FXMLLoader.load(getClass().getResource("BWVisualizerFXMLVer2.fxml"));//refer to indicated fxml file for interface modification
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
	public static void main(String[] args) {
                launch(args);
		CSVReader c = new CSVReader();
		try {
			PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s21.powerspec.csv"));
			PowerSpectrum q = new PowerSpectrum(c.readFile("powerspec/s22.powerspec.csv"));
			System.out.println(p.getVal(10, 11));
			for (int i=0;i<192;i++) {
				System.out.print("("+i+",");
				System.out.print(p.similarity(q, i, "sq euclidean"));
				System.out.print("),");
			//	System.out.print(q.similarity((3, i));
			//	System.out.print(", ");
			}
		} catch (FileNotFoundException e) {
			//do nothing
		}
	}
}