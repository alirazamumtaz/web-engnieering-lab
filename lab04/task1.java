import java.util.*;
import javax.swing.*;

// Math.PI

class task1{

    public static void main(String args[]){
		double r, b, h, sl;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius of circle: ");
		r = sc.nextDouble();
		System.out.print("Enter Base of Triangle: ");
		b = sc.nextDouble();
		System.out.print("Enter height of Triangle: ");
		h = sc.nextDouble();
		System.out.print("Enter side lenght of Square: ");
		sl = sc.nextDouble();
		TwoDimensionalShape[] shapes = new TwoDimensionalShape[3];
		shapes[0] = new Circle(r);
		shapes[1] = new Triangle(b,h);
		shapes[2] = new Square(sl);
		

		// printing the information of all the classes
		System.out.print("\nPrinting information of the objects");
		for(int i = 0; i < 3; i++){
			System.out.println(shapes[i]);
		}
	
		// finding the type of each instance of the array
		System.out.println("\nUse of \'isinstanceof\' operator and also finding the area polymarphically");
		for(int i = 0; i < 3; i++){
			if(shapes[i] instanceof Circle){
				System.out.println("\nshapes[" + i + "] is Circle");
				System.out.println("Area of Circle is: " + shapes[i].getArea());
			}
			else if(shapes[i] instanceof Square){
				System.out.println("\nshapes[" + i + "] is Square");
				System.out.println("Area of Square is: " + shapes[i].getArea());
			}
			else{
				System.out.println("\nshapes[" + i + "] is Triangle");
				System.out.println("Area of Triangle is: " + shapes[i].getArea());
			}
		}

	}
		
}
