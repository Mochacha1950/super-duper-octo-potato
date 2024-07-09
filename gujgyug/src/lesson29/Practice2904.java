package lesson29;

public class Practice2904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeManagementSystem2904 ems = new EmployeeManagementSystem2904();
		
		ems.registName();
		
		int id = ems.inputId();
		if (id != -1) {
			ems.showName(id);
		}
		
	}

}
