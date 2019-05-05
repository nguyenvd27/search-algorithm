package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CircleK extends Circle implements Comparable<CircleK>{
	private Integer number;
	private Text text;
	private Integer x;
	private Integer y;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	
	public CircleK() {
		super();
	}
	public CircleK(Integer number) {
		super();
		this.number = number;
		this.setFill(Color.web("#A7FF71"));//set ben trong
		this.setStroke(Color.web("#ff5050"));// set vien
		this.setStrokeWidth(3);// set do rong cua vien
		this.setRadius(30);
		
		this.text = new Text(number.toString());
		text.setFont(Font.font(20));
		text.setStroke(Color.BLACK);
	}
	
	public CircleK(Integer number, Integer layoutX, Integer layoutY) {
		super();
		this.number = number;
		this.x = layoutX;
		this.y = layoutY;
		this.setFill(Color.web("#B9FC90"));
		this.setStroke(Color.web("#ff5050"));
		this.setStrokeWidth(3);
		this.setRadius(30);
		
		this.text = new Text(number.toString());
		text.setFont(Font.font(20));
		text.setStroke(Color.BLACK);
	}
	
	public void changeBackGround(Color color) {
		this.setFill(color);
	}
	
	public void changeBorder(Color color) {
		this.setStroke(color);
	}
	
	public void delete() {
		this.setFill(null);
		this.setStroke(null);
		this.text.setVisible(false);
	}
	
	public void deleteRun() {
		this.setFill(null);
		this.setStroke(null);
	}
	
	@Override
	public int compareTo(CircleK circleK) {
		
		return this.getNumber()<circleK.getNumber()?1:-1;
	}
	
	
}
