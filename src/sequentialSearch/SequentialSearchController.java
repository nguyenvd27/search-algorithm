package sequentialSearch;

import sequentialSearch.SequentialSearch;

import java.io.IOException;
import javafx.util.Duration;
import java.util.ArrayList;

import shape.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
	private Label showKetQua;
	@FXML
	private AnchorPane paneRun;
	
	int array[]=new int[20];
	int size;
	int search;
	int x=100,y=0;
	CircleK newCircleK = new CircleK();
	CircleK circle = new CircleK();
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
			arrayCircleK.get(result).changeBorder(Color.GREEN);
		}
		
		if(result>=0) {
			//tao circle to len
			//create a timeline for moving the circle
	        Timeline timeline = new Timeline();
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.setAutoReverse(true);
	        //create a keyValue with factory: scaling the circle 2times
	        KeyValue keyValueX = new KeyValue(arrayCircleK.get(result).scaleXProperty(), 1.25);
	        KeyValue keyValueY = new KeyValue(arrayCircleK.get(result).scaleYProperty(), 1.25);
	        //create a keyFrame, the keyValue is reached at time 2s
	        Duration duration = Duration.millis(1000);
	        KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
	        //add the keyframe to the timeline
	        timeline.getKeyFrames().add(keyFrame);
	        timeline.play();
		}
		
		
//		circle = new CircleK(0);   
//	    circle.setRadius(30.0f);
//	    circle.setFill(Color.BROWN); 
//	    circle.setStrokeWidth(0);
//	      
//	    StackPane stackPane = new StackPane();
//		stackPane.getChildren().addAll(circle);
//		stackPane.setLayoutX(100);
//		stackPane.setLayoutY(100);
//		paneShow.getChildren().add(stackPane);
//		
//		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), 
//                new KeyValue(circle.layoutXProperty(), 300)));
//        timeline.setCycleCount(2);
//        timeline.play();
		
		
		
		//Drawing a Circle 
	      circle = new CircleK(0);   
	      circle.setRadius(30.0f);
	      circle.setFill(Color.web("#B9FC90")); 
	      circle.setStrokeWidth(0); 
	       
	      TranslateTransition translateTransition = new TranslateTransition(); 
	      
	      //Setting the duration of the transition  
	      translateTransition.setDuration(Duration.millis(4000)); 
	      
	      translateTransition.setNode(circle); 
	      //Setting the value of the transition along the x axis. 
	      if(result>=0) {
	    	  translateTransition.setByX(80*result);
	      }else {
	    	  translateTransition.setByX(80*size);
	      }
	       
	      //Setting the cycle count for the transition 
	      translateTransition.setCycleCount(50); 
	      //Setting auto reverse value to false 
	      translateTransition.setAutoReverse(false); 
	      
	      //Playing the animation 
	      translateTransition.play(); 
	      
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(circle);
			stackPane.setLayoutX(100);
			stackPane.setLayoutY(100);
			paneShow.getChildren().add(stackPane);
			
	}
	
	int xnext=100,ynext=100;
	
	int dem=0;
	public void next(ActionEvent event) {
		String strSearch = searchTextField.getText();
		int search = Integer.parseInt(strSearch);
		
		if(dem>0) {
			newCircleK.delete();
			arrayCircleK.get(dem-1).changeBorder(Color.web("#ff5050"));
		}
		newCircleK = new CircleK(search, xnext, ynext);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(newCircleK, newCircleK.getText());
		stackPane.setLayoutX(newCircleK.getX());
		stackPane.setLayoutY(newCircleK.getY());
		paneShow.getChildren().add(stackPane);
		
		arrayCircleK.get(dem).changeBorder(Color.GREEN);
		
		if(arrayCircleK.get(dem).getNumber()==search) {
			arrayCircleK.get(dem).changeBackGround(Color.RED);
			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(dem+1));
			nextButton.setVisible(false);
			
			//tao circle to len
			//create a timeline for moving the circle
	        Timeline timeline = new Timeline();
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.setAutoReverse(true);
	        //create a keyValue with factory: scaling the circle 2times
	        KeyValue keyValueX = new KeyValue(arrayCircleK.get(dem).scaleXProperty(), 1.25);
	        KeyValue keyValueY = new KeyValue(arrayCircleK.get(dem).scaleYProperty(), 1.25);
	        //create a keyFrame, the keyValue is reached at time 2s
	        Duration duration = Duration.millis(1000);
	        KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
	        //add the keyframe to the timeline
	        timeline.getKeyFrames().add(keyFrame);
	        timeline.play();
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
		circle.deleteRun();
		if(newCircleK.getNumber()!=null) {
			newCircleK.delete();
		}
		
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
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		stage.setTitle("OOP Project");
		stage.setScene(scene);
	}
}

