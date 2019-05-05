package binarySearch;

import shape.*;
import binarySearch.BinarySearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BinarySearchController {
	@FXML
	private AnchorPane paneShow;
	
	@FXML
	private TextField arrayTextField;
	@FXML
	private TextField searchTextField;
	@FXML
	private Label leftLabel;
	@FXML
	private Label midLabel;
	@FXML
	private Label rightLabel;
	
	int array[]=new int[20];
	int size,left=0,right=0;
	int search;
	int x=100,y=0;
	ArrayList<CircleK> arrayCircleK = new ArrayList<>();
	ArrayList<CircleK> arrayCircleKSorted = new ArrayList<>();
	public void ArrayInput(ActionEvent event) {
		String[] strArray = (arrayTextField.getText()).split(",");
		size = strArray.length;
		right = strArray.length -1;
		
		for(int i=0;i<size;i++) {
			array[i]=Integer.parseInt(strArray[i]);
			CircleK newCircleK = new CircleK(array[i],x,y);
			//newCircleK.changeBackGround(Color.RED);
			arrayCircleK.add(newCircleK);
			arrayCircleKSorted.add(newCircleK);
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
	
	public void sort(ActionEvent event) {
		Collections.sort(arrayCircleK, new Comparator<CircleK>() {
			@Override
			public int compare(CircleK circleK1, CircleK circleK2) {
				return circleK1.getNumber()>circleK2.getNumber()?1:-1;
			}
		});
		arrayCircleKSorted.clear();
		int xnew = 100,ynew=80;
		for(CircleK circleK: arrayCircleK) {
			System.out.println(circleK.getNumber());
			CircleK newCircleK = new CircleK(circleK.getNumber(),xnew,ynew);
			arrayCircleKSorted.add(newCircleK);
			xnew+=80;
		}
		
		for(CircleK circleK: arrayCircleKSorted) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(circleK, circleK.getText());
			stackPane.setLayoutX(circleK.getX());
			stackPane.setLayoutY(circleK.getY());
			paneShow.getChildren().add(stackPane);
		}
	}
	
	public void binarySearch(ActionEvent event) {
		//System.out.println("hello");
		String strSearch = searchTextField.getText();
		search = Integer.parseInt(strSearch);
		//System.out.println(search);
		int left = 0, right= arrayCircleKSorted.size()-1;
		System.out.println(right);
		BinarySearch obj = new BinarySearch();
		int result = obj.binarySearch(arrayCircleKSorted, left, right, search);
		if(result == -1) {
			System.out.println("khong tim thay");
		}else {
			System.out.println("Index "+result);
			arrayCircleKSorted.get(result).changeBackGround(Color.RED);
			//animation
            Timeline timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setAutoReverse(true);
            
            KeyValue keyValueX = new KeyValue(arrayCircleKSorted.get(result).scaleXProperty(), 1.25);
            KeyValue keyValueY = new KeyValue(arrayCircleKSorted.get(result).scaleYProperty(), 1.25);
     
            Duration duration = Duration.millis(1000);
            
            KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
            
            timeline.getKeyFrames().add(keyFrame);

            timeline.play();
		}
		
	}
	
	
	public void next(ActionEvent event) {
		String strSearch = searchTextField.getText();
		search = Integer.parseInt(strSearch);
		
		if (right >= left) { 
			System.out.println(right);
			System.out.println(left);
            int mid = left + (right - left) / 2; 
            
            midLabel.setText("mid: "+ mid);
        	leftLabel.setText("Left : " + left);
        	rightLabel.setText("Right: "+ right);
        	
            System.out.println(arrayCircleKSorted.get(mid).getNumber()+" va "+ search);
            if (arrayCircleKSorted.get(mid).getNumber() == search) {
            	
            	for(CircleK circleK: arrayCircleKSorted) {
            		circleK.changeBackGround(Color.GREEN);
            	}
            	
            	arrayCircleKSorted.get(mid).changeBackGround(Color.RED);
            	
            	//create a timeline for moving the circle
                Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                
              //create a keyValue with factory: scaling the circle 2times
                KeyValue keyValueX = new KeyValue(arrayCircleKSorted.get(mid).scaleXProperty(), 1.25);
                KeyValue keyValueY = new KeyValue(arrayCircleKSorted.get(mid).scaleYProperty(), 1.25);
         
                //create a keyFrame, the keyValue is reached at time 2s
                Duration duration = Duration.millis(1000);
                
                KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
                
                //add the keyframe to the timeline
                timeline.getKeyFrames().add(keyFrame);
         
                timeline.play();
            }
                
            if (arrayCircleKSorted.get(mid).getNumber() > search) {
            	//return binarySearch(arrayCircleK, l, mid - 1, x);
            	
            	for(CircleK circleK: arrayCircleKSorted) {
            		circleK.changeBackGround(Color.GREEN);
            	}
            	for(int i=left;i<=mid-1;i++) {
            		arrayCircleKSorted.get(i).changeBackGround(Color.RED);
            	}
            	
            	right=mid-1;
            }
            
            if (arrayCircleKSorted.get(mid).getNumber() < search) {
            	//return binarySearch(arrayCircleK, mid + 1, r, x);
            	
            	for(CircleK circleK: arrayCircleKSorted) {
            		circleK.changeBackGround(Color.GREEN);
            	}
            	for(int i=mid+1;i<=right;i++) {
            		arrayCircleKSorted.get(i).changeBackGround(Color.RED);
            	}
            	
            	left=mid+1;
            }
             
        } 
  
	}
	public void reset(ActionEvent event) {
		for(CircleK circleK: arrayCircleK) {
			circleK.delete();
		}
		arrayCircleK.clear();
		for(CircleK circleK: arrayCircleKSorted) {
			circleK.delete();
		}
		arrayCircleKSorted.clear();
		x=100;
		left=0;
		right=size-1;
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

