import java.util.*;

class Triangle extends TwoDimensionalShape{
	public double base, height;
    public double getArea(){
	//1⁄2(base*height)
		return (1.0/2.0)*(base*height);
	}
	Triangle(double base, double height){
		this.base = base;
		this.height = height;
	}
	public String toString(){
		return "Base of Triangle is: " + this.base + "\nHeight of Triangle is: " + this.height;
	}
}
