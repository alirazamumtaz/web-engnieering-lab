import java.util.*;



class tooLargeNumberException extends Exception {
	private double cgpa;

	public tooLargeNumberException (double cgpa)
	{  this.cgpa = cgpa;}

	public String toString()
	{return "tooLargeNumberException: CGPA must be less than or equal to 4";}
}
class toosmallNumberException extends Exception {
	private double cgpa;

	public toosmallNumberException (double cgpa)
	{  this.cgpa = cgpa;}

	public String toString()
	{return "toosmallNumberException: CGPA must be greater than 0";}
}

class Student {
	static Scanner sc = new Scanner(System.in);
	static String name;
	static double cgpa;
	public static void enterName(){
		System.out.print("Enter name of the Student: ");
		name = sc.nextLine();
	}
	public static void enterCGPA(){
		double in;
		System.out.print("Enter CGPA of the Student: ");
		in = sc.nextDouble();
		try {
			if(in > 4)  throw new tooLargeNumberException(in);
			if (in < 0) throw new toosmallNumberException(in);
			cgpa = in;
		} catch(tooLargeNumberException tlne){
			tlne.printStackTrace();
			System.out.println(tlne);
			enterCGPA();
		} catch(toosmallNumberException tsne){
			System.out.println(tsne);
			enterCGPA();
		}
	}
	public String toString(){
		showName();
		showCGPA();
	 return "\n";
	}
	public static void showName(){
		System.out.println("Students's Name: " + name);
	}
	public static void showCGPA(){
		System.out.println("Students's CGPA: " + cgpa);
	}
}