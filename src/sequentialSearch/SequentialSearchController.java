//package sequentialSearch;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import shape.Square;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.Point2D;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//public class SequentialSearchController {
//	
//	@FXML
//	private TextField arrayTextField;
//	@FXML
//	private TextField search;
//	@FXML
//	private Button nextButton;
//	@FXML
//	private Canvas canvasSquare;
//	@FXML
//	private Label showKetQua;
//
//	int array[]=new int[10];
//	int size;
//	ArrayList<Square> arraySquare = new ArrayList<>();
//	public void ArrayInput(ActionEvent event) {
//		String[] strArray = (arrayTextField.getText()).split(",");
//		size = strArray.length;
//		
//		for(int i=0;i<size;i++) {
//			array[i]=Integer.parseInt(strArray[i]);
//		}
//		
////		for (int i = 0; i < size; i++) {
////			System.out.println(array[i]);
////		}
//		
//		GraphicsContext gc = canvasSquare.getGraphicsContext2D();
//		int num=100;
//		for(int i=0;i<size;i++) {
//			Square newSq = new Square(array[i], new Point2D(num, 30));
//			newSq.draw(gc);
//			arraySquare.add(newSq);
//			num=num+80;
//		}
//		
//		//arrayTextField.setText("");
//	}
//	
//	public void SequentialSearch(ActionEvent event) {
//		String strSearch = search.getText();
//		int search = Integer.parseInt(strSearch);
//		System.out.println(search);
//		int ktra=0;
//		
//		GraphicsContext gc = canvasSquare.getGraphicsContext2D();
//		for (int i = 0; i < size; i++) {
//			if(array[i]==search) {
//				System.out.println("Tim thay "+search+" o vi tri thu "+(i+1));
//				showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(i+1));
//				arraySquare.get(i).changeColorSquare(gc);
//				ktra=1;
//				break;
//			}	
//		}
//		
//		if(ktra==0) {
//			System.out.println("Khong tim thay");
//			showKetQua.setText("Phần tử "+search+" không có trong mảng");
//		}
//	}
//	
//	int xnext=100,ynext=100;
//	int dem=0;
//	Square newSquare;
//	public void next(ActionEvent event) {
//		String strSearch = search.getText();
//		int search = Integer.parseInt(strSearch);
//		
//		GraphicsContext gc = canvasSquare.getGraphicsContext2D();
//		
//		if(dem>0) {
//			newSquare.deleteSquare(gc);
//			//ve lai mau ban dau
//			arraySquare.get(dem-1).draw(gc);
//		}
//		
//		newSquare = new Square(search, new Point2D(xnext, ynext));
//		newSquare.draw(gc);
//		//newSquare.searchNumber(gc);
//		xnext+=80;
//		
//		arraySquare.get(dem).changeColorBorder(gc);
//		if(array[dem]==search) {
//			//newSquare.changeColorBorder(gc);
//			newSquare.changeColorSquare(gc);
//			arraySquare.get(dem).changeColorSquare(gc);
//			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(dem+1));
//			nextButton.setVisible(false);
//		}
//		
//		if(dem>=size-1&&array[dem]!=search) {
//			showKetQua.setText("Phần tử "+search+" không có trong mảng");
//			nextButton.setVisible(false);
//		}
//		System.out.println(dem +" với "+ size );
//		dem++;
//	}
//	
//	public void goBack(ActionEvent event) throws IOException {
//		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		// tao ra loader de load LinearSeach.fxml
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("../view/MainScene.fxml"));
//		Parent mainScene = loader.load();
//		Scene scene = new Scene(mainScene);
//		stage.setScene(scene);
//	}
//}




package sequentialSearch;

import sequentialSearch.SequentialSearch;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import shape.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class SequentialSearchController {
	
	@FXML
	private AnchorPane paneShow;
	@FXML
	private TextField arrayTextField;
	@FXML
	private TextField searchTextField;
	@FXML
	private Button nextButton;
	@FXML
	private Canvas canvasSquare;
	@FXML
	private Label showKetQua;

//	int array[]=new int[10];
//	int size;
//	ArrayList<Square> arraySquare = new ArrayList<>();
//	public void ArrayInput(ActionEvent event) {
//		String[] strArray = (arrayTextField.getText()).split(",");
//		size = strArray.length;
//		
//		for(int i=0;i<size;i++) {
//			array[i]=Integer.parseInt(strArray[i]);
//		}
//		
//		GraphicsContext gc = canvasSquare.getGraphicsContext2D();
//		int num=100;
//		for(int i=0;i<size;i++) {
//			Square newSq = new Square(array[i], new Point2D(num, 30));
//			newSq.draw(gc);
//			arraySquare.add(newSq);
//			num=num+80;
//		}
//		
//		//arrayTextField.setText("");
//	}
	
	
	int array[]=new int[20];
	int size;
	int search;
	int x=100,y=0;
	CircleK newCircleK = new CircleK();
	ArrayList<CircleK> arrayCircleK = new ArrayList<>();
	public void ArrayInput(ActionEvent event) {
		String[] strArray = (arrayTextField.getText()).split(",");
		size = strArray.length;
		
		for(int i=0;i<size;i++) {
			array[i]=Integer.parseInt(strArray[i]);
			CircleK newCircleK = new CircleK(array[i],x,y);
			arrayCircleK.add(newCircleK);
			x+=80;
		}
		
		for(CircleK circleK: arrayCircleK) {
			System.out.println(circleK.getX());
		}
		
		for(CircleK circleK: arrayCircleK) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(circleK, circleK.getText());
			stackPane.setLayoutX(circleK.getX());
			stackPane.setLayoutY(circleK.getY());
			paneShow.getChildren().add(stackPane);
		}
		
	}
	
	public void SequentialSearch(ActionEvent event) {
		
		String strSearch = searchTextField.getText();
		int search = Integer.parseInt(strSearch);
		SequentialSearch obj = new SequentialSearch();
		int result = obj.sequentialSearch(arrayCircleK, search);
		
		if(result==-1) {
			System.out.println("Khong tim thay");
			showKetQua.setText("Phần tử "+search+" không có trong mảng");
		}else {
			System.out.println("Tim thay "+search+" o vi tri thu "+(result+1));
			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(result+1));
			arrayCircleK.get(result).changeBackGround(Color.RED);
		}
		
		
		CircleK circleK = new CircleK(11, 100, 200);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(circleK, circleK.getText());
		stackPane.setLayoutX(circleK.getX());
		stackPane.setLayoutY(circleK.getY());
		paneShow.getChildren().add(stackPane);
		
		//create a timeline for moving the circle
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        
      //create a keyValue with factory: scaling the circle 2times
        KeyValue keyValueX = new KeyValue(circleK.scaleXProperty(),300);
        KeyValue keyValueY = new KeyValue(circleK.scaleYProperty(),300);
 
        //create a keyFrame, the keyValue is reached at time 2s
        //Duration duration = Duration.millis(1000);
        javafx.util.Duration duration = javafx.util.Duration.seconds(1);
        
        KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
        
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
 
        timeline.play();
	}
	
	int xnext=100,ynext=100;
	
	int dem=0;
	public void next(ActionEvent event) {
		String strSearch = searchTextField.getText();
		int search = Integer.parseInt(strSearch);
		
		if(dem>0) {
			newCircleK.delete();
			arrayCircleK.get(dem-1).changeBorder(Color.BLUE);
		}
		newCircleK = new CircleK(search, xnext, ynext);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(newCircleK, newCircleK.getText());
		stackPane.setLayoutX(newCircleK.getX());
		stackPane.setLayoutY(newCircleK.getY());
		paneShow.getChildren().add(stackPane);
		
		arrayCircleK.get(dem).changeBorder(Color.YELLOW);
		
		if(arrayCircleK.get(dem).getNumber()==search) {
			arrayCircleK.get(dem).changeBackGround(Color.RED);
			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(dem+1));
			nextButton.setVisible(false);
		}
		
		if(dem>=size-1 && arrayCircleK.get(dem).getNumber()!=search) {
			showKetQua.setText("Phần tử "+search+" không có trong mảng");
			nextButton.setVisible(false);
		}
		
		xnext+=80;
		dem++;
	}
	
	public void reset(ActionEvent event) {
		System.out.println("Hello");
		for(CircleK circleK: arrayCircleK) {
			circleK.delete();
		}
		arrayCircleK.clear();
		x=100;xnext=100;dem=0;
		newCircleK.delete();
		nextButton.setVisible(true);
		showKetQua.setText("");
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

