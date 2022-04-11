import java.util.*;

class Square extends TwoDimensionalShape{
	public double side_length;
    public double getArea(){
	//side_length^2
		return side_length*side_length;	
	
	}
	public String toString(){
		return "Side lenght of Square is: " + this.side_length;
	}
	
	Square(double side_length){
		this.side_length = side_length;
	}
}
