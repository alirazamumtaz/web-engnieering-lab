import java.util.*;
import javax.swing.*;

class task1{

    public static void showMenu(){
	    JOptionPane.showMessageDialog(null,"**********  HR Management System  **********\n"
	    	+"1.\tAdd Record\n"
	    	+"2.\tView Record\n"
	    	+"3.\tDelete Record\n"
	    	+"4.\tExit"
	    );
    }
	
	public static int addRecord(){
		Employee newEmp = new Employee();
		newEmp.name = JOptionPane.showInputDialog("Enter the Name of emplyee.");
		newEmp.gender = JOptionPane.showInputDialog("Enter the Gender of emplyee.");
		newEmp.phone_number = JOptionPane.showInputDialog("Enter the Phone Number of emplyee.");
		employees.add(newEmp);
		JOptionPane.showMessageDialog(null,"Record has been saved successfully !");
		return 0; // Return Success.
	}

	public static int deleteRecord(int id){
		employees.remove(id);
		Employee.id--;
		JOptionPane.showMessageDialog(null,"Record has been deleted successfully.");
		return 0; // Return success.
	}

    public static int viewRecord(int id){
    	if(employees.size() < 1){
    		JOptionPane.showMessageDialog(null,"No Record Present.");
    		return -1; // Return Faliure
    	}

		JOptionPane.showMessageDialog(null,"***  Record of ID" + Employee.id + "  ***\n\n" + "ID:\t"
											+ employees.get(id).id
											+"\nName:\t" + employees.get(id).name
											+"\nGender:\t" + employees.get(id).gender
											+"\nPhone#:\t" + employees.get(id).phone_number
											);
		return 0; // Return Success.

    }
    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static void main(String args[]){
		int n;
		System.out.print("Enter total number of Studets: ");
		while(true){
		    int choice;
			showMenu();
			System.out.print("\nEnter Choice (1-4): ");
			choice = Integer.parseInt(JOptionPane.showInputDialog("Enter Choice 1-4"));
			switch(choice){
				case 1:
			    	addRecord();
					break;
				case 2:
					viewRecord(Integer.parseInt(JOptionPane.showInputDialog("Please enter the ID of Employee that you want to view!")));
					break;
				case 3:
					deleteRecord(Integer.parseInt(JOptionPane.showInputDialog("Please enter the ID of Employee that you want to delete!")));
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Thank you for using");
					return;
				default:
					JOptionPane.showMessageDialog(null,"Wrong Choice. Please select between [1-4]");
					break;
			}
		}
    }
}
