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
	@FXML
	private Label showKetQua;
	
	int array[]=new int[100];
	int size,left=0,right=0;
	int search;
	int x=100,y=0;
	ArrayList<Square> arraySquare = new ArrayList<>();
	ArrayList<Square> arraySquareSorted = new ArrayList<>();//arraList da sap xep
	public void ArrayInput(ActionEvent event) {
		String[] strArray = (arrayTextField.getText()).split(",");
		size = strArray.length;
		right = strArray.length -1;
		
		for(int i=0;i<size;i++) {
			array[i]=Integer.parseInt(strArray[i]);
			Square newSquare = new Square(array[i],x,y);
			arraySquare.add(newSquare);
			arraySquareSorted.add(newSquare);
			x+=80;
		}
		
		for(Square square: arraySquare) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(square, square.getText());
			stackPane.setLayoutX(square.getXx());
			stackPane.setLayoutY(square.getYy());
			paneShow.getChildren().add(stackPane);
		}
		
	}
	
	public void sort(ActionEvent event) {
		Collections.sort(arraySquare, new Comparator<Square>() {
			@Override
			public int compare(Square square1, Square square2) {
				return square1.getNumber()>square2.getNumber()?1:-1;
			}
		});
		arraySquareSorted.clear();
		int xnew = 100,ynew=80;
		for(Square square: arraySquare) {
			System.out.println(square.getNumber());
			Square newSquare = new Square(square.getNumber(),xnew,ynew);
			arraySquareSorted.add(newSquare);
			xnew+=80;
		}
		
		for(Square square: arraySquareSorted) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(square, square.getText());
			stackPane.setLayoutX(square.getXx());
			stackPane.setLayoutY(square.getYy());
			paneShow.getChildren().add(stackPane);
		}
	}
	
	public void binarySearch(ActionEvent event) {
		String strSearch = searchTextField.getText();
		search = Integer.parseInt(strSearch);

		int left = 0, right= arraySquareSorted.size()-1;
		System.out.println(right);
		BinarySearch obj = new BinarySearch();
		int result = obj.binarySearch(arraySquareSorted, left, right, search);
		if(result == -1) {
			System.out.println("khong tim thay");
			showKetQua.setText("Không tìm thấy phần tử "+search + " trong mảng");
		}else {
			System.out.println("Index "+result);
			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí "+(result+1));
			arraySquareSorted.get(result).changeBackGround(Color.RED);
			arraySquareSorted.get(result).changeBorder(Color.GREEN);
			//animation
            Timeline timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setAutoReverse(true);
            
            KeyValue keyValueX = new KeyValue(arraySquareSorted.get(result).scaleXProperty(), 1.5);
            KeyValue keyValueY = new KeyValue(arraySquareSorted.get(result).scaleYProperty(), 1.5);
            Duration duration = Duration.millis(1000);
            KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
		}
		
	}
	
	//sau moi lan next can phai cap nhat lai bien left, right, mid
	public void next(ActionEvent event) {
		String strSearch = searchTextField.getText();
		search = Integer.parseInt(strSearch);
		
		if (right >= left) { 
			System.out.println(right);
			System.out.println(left);
            int mid = left + (right - left) / 2; 
            
            midLabel.setText("MID: "+ mid);
        	leftLabel.setText("LEFT : " + left);
        	rightLabel.setText("RIGHT: "+ right);
        	
            System.out.println(arraySquareSorted.get(mid).getNumber()+" va "+ search);
            if (arraySquareSorted.get(mid).getNumber() == search) {
            	showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí "+(mid+1));
            	for(Square square: arraySquareSorted) {
            		square.changeBackGround(Color.web("#B9FC90"));
            	}
            	
            	arraySquareSorted.get(mid).changeBackGround(Color.RED);
            	arraySquareSorted.get(mid).changeBorder(Color.GREEN);
            	
            	//create a timeline for moving the Square
            	Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                //create a keyValue with factory: scaling the square 2times
                KeyValue keyValueX = new KeyValue(arraySquareSorted.get(mid).scaleXProperty(), 1.5);
                KeyValue keyValueY = new KeyValue(arraySquareSorted.get(mid).scaleYProperty(), 1.5);
                //create a keyFrame, the keyValue is reached at time 2s
                Duration duration = Duration.millis(1000);
                KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
                //add the keyframe to the timeline
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            }
                
            if (arraySquareSorted.get(mid).getNumber() > search) {
            	for(Square square: arraySquareSorted) {
            		square.changeBackGround(Color.web("#B9FC90"));
            	}
            	for(int i=left;i<=mid-1;i++) {
            		arraySquareSorted.get(i).changeBackGround(Color.RED);
            	}
            	right=mid-1;
            }
            
            if (arraySquareSorted.get(mid).getNumber() < search) {
            	for(Square square: arraySquareSorted) {
            		square.changeBackGround(Color.web("#B9FC90"));
            	}
            	for(int i=mid+1;i<=right;i++) {
            		arraySquareSorted.get(i).changeBackGround(Color.RED);
            	}
            	left=mid+1;
            } 
        } else {
        	showKetQua.setText("Không tìm thấy phần tử "+search + " trong mảng");
        }
	}
	
	public void reset(ActionEvent event) {
		for(Square square: arraySquare) {
			square.delete();
		}
		arraySquare.clear();
		for(Square square: arraySquareSorted) {
			square.delete();
		}
		arraySquareSorted.clear();
		x=100;
		left=0;
		right=size-1;
		
		leftLabel.setText("LEFT: ");
		rightLabel.setText("RIGHT: ");
		midLabel.setText("MID: ");
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

