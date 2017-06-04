import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class BrainwaveClient extends Application{
    @Override
    public void start(Stage primaryStage) throws IOException {
        /*generic container class*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BWVisualizerFXMLVer2.fxml"));
		loader.setController(new BWVisualizerFXMLController());
		Parent root = loader.load();
		Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*Parent root = FXMLLoader.load(getClass().getResource("/BW-Visualizer/BWVisualizerFXMLVer2.fxml"));//refer to indicated fxml file for interface modification
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        }
	public static void main(String[] args) {
      //  try {
        	launch(args);
        	System.out.println("h");
      //  } catch (Exception e) {
      //  	System.out.println(e.getCause());
      //  }
		CSVReader c = new CSVReader();
		try {
			PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s21.powerspec.csv"));
			PowerSpectrum q = new PowerSpectrum(c.readFile("powerspec/s22.powerspec.csv"));
			TmpAnimTest a = new TmpAnimTest();
			a.startAnimation();
		//	AnimTest a = new AnimTest();
		//	Stage s = new Stage();
		//	a.animatePSpec(p, s);
		} catch (Exception e) {
			//do nothing
		}
	}
}