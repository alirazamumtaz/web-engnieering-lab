import java.util.*;

class Driver {
	public static Student[] students;
	static int n;
	public static void save(){
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		student.enterName();
		student.enterCGPA();
		System.out.print("Enter student number: ");
		int i = sc.nextInt();
		try {
				students[i] = student;	
		} catch(ArrayIndexOutOfBoundsException aiobe){
			System.out.println("Student number must be between[0-" + n + ": ");
		}
		
	}
	public static void retrieve(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student number: ");
		int i = sc.nextInt();
		try {
			System.out.println(students[i]);
		} catch(ArrayIndexOutOfBoundsException aiobe){
			System.out.println("Student number must be between[0-" + n + ": ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many Students you want to add? ");
		n = sc.nextInt();
		try {
			students = new Student[n];
		} catch (NegativeArraySizeException nase) {
			nase.printStackTrace();
			System.out.println("People count must be positive");
			System.exit(0);
		}
		int choice = 0;
		while(choice != 3){
			System.out.println("1. Add value in the array");
			System.out.println("2. Retrieve and print the information of specific student at index n.");
			System.out.println("3. Exit");
			choice = sc.nextInt();
			switch(choice){
			case 1: save(); break;
			case 2: retrieve(); break;
			case 3: break;
			default: System.out.println("Wrong Choice. Try agian....\n"); break;
			}
		}
	}
}
