package binarySearch;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BinarySearchController {
	public void goBack(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		// tao ra loader de load LinearSeach.fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/MainScene.fxml"));
		Parent mainScene = loader.load();
		Scene scene = new Scene(mainScene);
		stage.setScene(scene);
	}
}

