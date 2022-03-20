import java.util.Scanner;
class Student{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] studentName 	= 	{"Ali", 		"Raza", 		"Faran"		};
		String[] studentId 		= 	{"BCS19M513", 	"BCS19M514", 	"BCS19M534"	};
		int n = studentName.length;
		while(true){
			System.out.print("Enter nummber of students to be displayed: ");
			int t = sc.nextInt();
			if(n < t || t < 1){
				System.out.println("There are not enough students. Please try again");
			}
			else{
				for(int i = 0; i < t; i++){
					System.out.println("Name:\t" + studentName[i]);
					System.out.println("ID:\t" + studentId[i] + '\n');
				}
				break;
			}
		}
	}
}
		