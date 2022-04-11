import java.util.*;

class Circle extends TwoDimensionalShape{
	double radius;
    public double getArea(){
	//πr2
		return Math.PI * this.radius*2;	
	
	}
	public String toString(){
		return "Radius of Cricle is: " + this.radius;
	}
	Circle(double radius){
		this.radius = radius;
	} 
}
