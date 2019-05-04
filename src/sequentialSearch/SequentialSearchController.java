package sequentialSearch;

import java.io.IOException;
import java.util.ArrayList;

import shape.Square;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SequentialSearchController {
	
	@FXML
	private TextField arrayTextField;
	@FXML
	private TextField arraySize;
	@FXML
	private TextField search;
	@FXML
	private Canvas canvasSquare;

	
	//int size = Integer.parseInt(arraySize.getText());
	int array[]=new int[10];
	int size;
	ArrayList<Square> arraySquare = new ArrayList<>();
	public void ArrayInput(ActionEvent event) {
//		String strArray = arrayTextField.getText();
//		System.out.println(strArray);
//		String[] arraySplit = strArray.split(",");
		
		String[] strArray = (arrayTextField.getText()).split(",");
		size = strArray.length;
		
		for(int i=0;i<size;i++) {
			array[i]=Integer.parseInt(strArray[i]);
		}
		
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
		
		GraphicsContext gc = canvasSquare.getGraphicsContext2D();
		int num=100;
		for(int i=0;i<size;i++) {
			Square newSquare = new Square(array[i], new Point2D(num, 30));
			newSquare.draw(gc);
			arraySquare.add(newSquare);
			num=num+80;
		}
		
		arrayTextField.setText("");
	}
	
	public void SequentialSearch(ActionEvent event) {
		String strSearch = search.getText();
		int search = Integer.parseInt(strSearch);
		System.out.println(search);
		System.out.println(array[1]+array.toString());
		int ktra=0,vtri=-1;
		
		int x=100,y=100;
		GraphicsContext gc = canvasSquare.getGraphicsContext2D();
		for (int i = 0; i < size; i++) {
			Square newSquare = new Square(search, new Point2D(x, y));
			newSquare.draw(gc);
			if(array[i]==search) {
				ktra=1;
				vtri=i+1;
				for(Square square: arraySquare) {
					if(square.getSearchNum()==search) {
						System.out.println("hihi");
						square.draw2(gc);
					}
				}
				break;
			}	
			x=x+80;
			//y=y+80;
			y=y+40;
		}
		
		if(ktra==1) {
			System.out.println("Tim thay "+search+" o vi tri thu"+vtri);
			
		}else {
			System.out.println("Khong tim thay");
			
		}
	}
	
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
