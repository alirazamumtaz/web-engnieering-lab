import java.util.*;
import javax.swing.*;
class VectorMaths{
	public static void main(String[] args){
		Vector v1 = new Vector();
		Vector v2 = new Vector();

		v1.x = Integer.parseInt(JOptionPane.showInputDialog("Enter x value Vector 1!"));
		v1.y = Integer.parseInt(JOptionPane.showInputDialog("Enter y value Vector 1!"));
		v2.x = Integer.parseInt(JOptionPane.showInputDialog("Enter x value Vector 1!"));
		v2.y = Integer.parseInt(JOptionPane.showInputDialog("Enter y value Vector 1!"));

		JOptionPane.showMessageDialog(null,"Sum = x: " + (Vector.addVect(v1,v2)).x + "\nSum = y: " + (v1.addVect(v1,v2)).y);
		JOptionPane.showMessageDialog(null,"Sub = x: " + (Vector.subVect(v1,v2)).x + "\nSub = y: " + (v1.subVect(v1,v2)).y);
		JOptionPane.showMessageDialog(null,"Magnitude of v1: " + v1.magnitude());

		int n = Integer.parseInt(JOptionPane.showInputDialog("Enter n to multiply as scaler!"));
		v1.scalerMul(n);
		JOptionPane.showMessageDialog(null,"Scaler Multiplication of v1 with" + n + "is\nX: " + v1.x + "\nY: " + v1.y);
	}
}