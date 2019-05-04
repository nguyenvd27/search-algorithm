package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	//Chuyen sang Scene Sequential Search
	public void ChangeSequentialSearchScene(ActionEvent event) throws IOException {
		//lay stage
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		// tao ra loader de load LinearSeach.fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/SequentialSearch.fxml"));
		Parent sequentialSeach = loader.load();
		Scene scene = new Scene(sequentialSeach,1100,700);
		stage.setScene(scene);
		stage.setTitle("Sequential Search");
	}
	
	//Chuyen sang Scene Binary Search
	public void ChangeBianrySearchScene(ActionEvent event) throws IOException {
		//lay stage
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		// tao ra loader de load LinearSeach.fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/BinarySearch.fxml"));
		Parent binarySeach = loader.load();
		Scene scene = new Scene(binarySeach,1100,700);
		stage.setScene(scene);
		stage.setTitle("Binary Search");
	}
}