package shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Square {
	
	Font font =  Font.font("Cooper Black", FontWeight.BOLD, 16);
	int RADIUS = 26;
	private Integer searchNum;
	
	private Point2D point;
	private Color backgroundColor;
	private Color borderColor;
	private Color fontColor;
	
	public void draw(GraphicsContext gc) {
		
		// Sets the width of the lines
		gc.setLineWidth(5);
		
		// Create a square
		gc.setFill(getBackgroundColor());
		gc.fillRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		gc.setStroke(getBorderColor());
			
		// Outline the square border
		gc.strokeRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		// Draw the id number inside the circle
		gc.setFont(font);
		gc.setFill(getFontColor());
		gc.fillText(getKey(),point.getX()-10, point.getY()+5);
	}
	
	// generate getter and setter
	public int getRADIUS() {
		return RADIUS;
	}
	public void setRADIUS(int rADIUS) {
		RADIUS = rADIUS;
	}
	public Integer getSearchNum() {
		return searchNum;
	}
	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}
	public Point2D getPoint() {
		return point;
	}
	public void setPoint(Point2D point) {
		this.point = point;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	
	//generate constructor
	public Square(Integer searchNum) {
		super();
		this.searchNum = searchNum;
		this.backgroundColor = Color.GREEN;
		this.borderColor = Color.BLUE;
		this.fontColor = Color.web("#FCFCFC");
	}
	public Square(Integer searchNum, Point2D point) {
		super();
		this.searchNum = searchNum;
		this.point = point;
		this.backgroundColor = Color.GREEN;
		this.borderColor = Color.BLUE;
		this.fontColor = Color.web("#FCFCFC");
	}
	
	
	
	public String getKey() {
		return Integer.toString(getSearchNum());
	}
	
	//change color object square	
	public void searchNumber(GraphicsContext gc) {
		gc.setLineWidth(5);
		gc.setFill(Color.RED);
		gc.fillRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		gc.setStroke(Color.YELLOW);
		
		// Outline the square border
		gc.strokeRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		// Draw the id number inside the circle
		gc.setFont(font);
		gc.setFill(getFontColor());
		gc.fillText(getKey(),point.getX()-10, point.getY()+5);
	}
	public void changeColorSquare(GraphicsContext gc) {
		gc.setLineWidth(5);
		gc.setFill(Color.RED);
		gc.fillRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		gc.setStroke(Color.YELLOW);
		
		// Outline the square border
		gc.strokeRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		// Draw the id number inside the circle
		gc.setFont(font);
		gc.setFill(getFontColor());
		gc.fillText(getKey(),point.getX()-10, point.getY()+5);
	}

	public void changeColorBorder(GraphicsContext gc) {
		gc.setLineWidth(5);
		gc.setFill(Color.GREEN);
		gc.fillRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		gc.setStroke(Color.ORANGE);
		
		gc.strokeRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		// Draw the id number inside the circle
		gc.setFont(font);
		gc.setFill(getFontColor());
		gc.fillText(getKey(),point.getX()-10, point.getY()+5);
	}
	
	public void deleteSquare(GraphicsContext gc) {
		gc.setLineWidth(7);
		gc.setFill(Color.web("#F5F5F5"));
		gc.fillRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		gc.setStroke(Color.web("#F5F5F5"));
		gc.strokeRoundRect(point.getX() - RADIUS,point.getY() - RADIUS, 60, 60, 10, 10);
		gc.setFont(null);
		//gc.setFill(null);
		gc.fillText("", point.getX()-10, point.getY()+5);
	}
	
	@Override
	public String toString() {
		
		return "Search Num# " + searchNum  + 
				" (x,y) = ("  + point.getX() + ", " + point.getY() + ")";
	}
}











