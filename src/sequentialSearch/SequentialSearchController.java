package sequentialSearch;

import sequentialSearch.SequentialSearch;

import java.io.IOException;
import javafx.util.Duration;
import java.util.ArrayList;

import shape.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
	int x=100,y=0;// xac dinh toa do cua square theo truc Oxy
	//tao object newSquare, square
	Square newSquare = new Square();
	Square square = new Square();
	//tao arrayList arraySquare de luu danh sach object Square
	ArrayList<Square> arraySquare = new ArrayList<>();
	
	//ham goi khi nhap mang
	public void ArrayInput(ActionEvent event) {
		//tach chuoi dau vao thanh mang va luu vao arraySquare
		String[] strArray = (arrayTextField.getText()).split(",");
		size = strArray.length;
		
		for(int i=0;i<size;i++) {
			array[i]=Integer.parseInt(strArray[i]);
			Square newSquare = new Square(array[i],x,y);
			arraySquare.add(newSquare);
			x+=80;
		}
		
		//Ve square ra man hinh, dung stackPane
		for(Square square: arraySquare) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(square, square.getText());
			stackPane.setLayoutX(square.getXx());
			stackPane.setLayoutY(square.getYy());
			paneShow.getChildren().add(stackPane);
		}
		
	}
	
	public void SequentialSearch(ActionEvent event) {
		String strSearch = searchTextField.getText();
		int search = Integer.parseInt(strSearch);
		
		SequentialSearch obj = new SequentialSearch();
		int result = obj.sequentialSearch(arraySquare, search);
		
		if(result==-1) {
			System.out.println("Khong tim thay");
			showKetQua.setText("Phần tử "+search+" không có trong mảng");
		}else {
			System.out.println("Tim thay "+search+" o vi tri thu "+(result+1));
			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(result+1));
			arraySquare.get(result).changeBackGround(Color.RED);
			arraySquare.get(result).changeBorder(Color.GREEN);
		}
		
		if(result>=0) {
			//tao square to len
			//create a timeline for moving the square
	        Timeline timeline = new Timeline();
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.setAutoReverse(true);
	        //create a keyValue with factory: scaling the square 2times
	        KeyValue keyValueX = new KeyValue(arraySquare.get(result).scaleXProperty(), 1.25);
	        KeyValue keyValueY = new KeyValue(arraySquare.get(result).scaleYProperty(), 1.25);
	        //create a keyFrame, the keyValue is reached at time 2s
	        Duration duration = Duration.millis(1000);
	        KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
	        //add the keyframe to the timeline
	        timeline.getKeyFrames().add(keyFrame);
	        timeline.play();
		}
		 
		//Drawing a Square
		  if(result>=0) {
			  square = new Square(arraySquare.get(result).getNumber(),100,100);
		  }else {
			  square = new Square(search,100,100);
		  }
	      
	      square.setWidth(60);
	      square.setHeight(60);
	      square.setFill(Color.web("#B9FC90"));
	      
	      StackPane stackPane = new StackPane();
		  stackPane.getChildren().addAll(square,square.getText());
		  stackPane.setLayoutX(100);
		  stackPane.setLayoutY(100);
		  paneShow.getChildren().add(stackPane);
			
	      TranslateTransition translateTransition = new TranslateTransition(); 
	      
	      //Setting the duration of the transition  
	      translateTransition.setDuration(Duration.millis(4000)); 
	      translateTransition.setNode(square); 
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
	      
	      //Cho text chay
	      TranslateTransition translateTransition2 = new TranslateTransition(); 
	      translateTransition2.setDuration(Duration.millis(4000)); 
	      translateTransition2.setNode(square.getText()); 
	      if(result>=0) {
	    	  translateTransition2.setByX(80*result);
	      }else {
	    	  translateTransition2.setByX(80*size);
	      }
	      translateTransition2.setCycleCount(50); 
	      translateTransition2.setAutoReverse(false); 
	      translateTransition2.play(); 
	}
	
	int xnext=100,ynext=100;
	int dem=0;
	
	public void next(ActionEvent event) {
		String strSearch = searchTextField.getText();
		int search = Integer.parseInt(strSearch);
		//dem>0 thi xoa square o phia truoc
		if(dem>0) {
			newSquare.delete();
			arraySquare.get(dem-1).changeBorder(Color.web("#ff5050"));
		}
		newSquare = new Square(search, xnext, ynext);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(newSquare, newSquare.getText());
		stackPane.setLayoutX(newSquare.getXx());
		stackPane.setLayoutY(newSquare.getYy());
		paneShow.getChildren().add(stackPane);
		
		arraySquare.get(dem).changeBorder(Color.GREEN);
		
		if(arraySquare.get(dem).getNumber()==search) {
			arraySquare.get(dem).changeBackGround(Color.RED);
			showKetQua.setText("Tìm thấy phần tử "+search+" ở vị trí thứ "+(dem+1));
			nextButton.setVisible(false);
			
			//tao square to len
			//create a timeline for moving the square
	        Timeline timeline = new Timeline();
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.setAutoReverse(true);
	        //create a keyValue with factory: scaling the square 2times
	        KeyValue keyValueX = new KeyValue(arraySquare.get(dem).scaleXProperty(), 1.5);
	        KeyValue keyValueY = new KeyValue(arraySquare.get(dem).scaleYProperty(), 1.5);
	        //create a keyFrame, the keyValue is reached at time 2s
	        Duration duration = Duration.millis(1000);
	        KeyFrame keyFrame = new KeyFrame(duration , keyValueX, keyValueY);
	        //add the keyframe to the timeline
	        timeline.getKeyFrames().add(keyFrame);
	        timeline.play();
		}
		
		if(dem>=size-1 && arraySquare.get(dem).getNumber()!=search) {
			showKetQua.setText("Phần tử "+search+" không có trong mảng");
			nextButton.setVisible(false);
		}
		
		xnext+=80;//dich chuyen theo truc Ox
		dem++;//tang bien dem de xoa dc phan tu truoc no
	}
	
	public void reset(ActionEvent event) {
		System.out.println("Hello");
		for(Square square: arraySquare) {
			square.delete();
		}
		arraySquare.clear();
		x=100;xnext=100;dem=0;
		square.delete();
		if(newSquare.getNumber()!=null) {
			newSquare.delete();
		}
		
		nextButton.setVisible(true);
		showKetQua.setText("");
	}
	
	//tro ve scene truoc
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