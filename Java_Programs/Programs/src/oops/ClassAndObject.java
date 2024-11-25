package oops;

// Implementation of Class,Objects and Constructors
public class ClassAndObject {

	public static void main(String[] args) {
		
		Example obj = new Example();
		obj.display();
		
		Example obj2 = new Example(1,"Saru","Testing");
		obj2.display();
		
		Example obj3 = new Example(obj2);
		obj3.display();
	}

}
class Example{
	 int empId;
	 String empName;
	 String empDomain;
	 
	 // Default Constructor
	 public Example(){
		 System.out.println("Employee Details");
	 }
	 
	 // Parameterized constructor
	 public Example(int empId,String empName,String empDomain){
		 this.empId = empId;
		 this.empName = empName;
		 this.empDomain = empDomain;
	 }
	 
	 // Copy Constructor
	 public Example(Example employee) {
		 this.empId = employee.empId;
		 this.empName = employee.empName;
		 this.empDomain = employee.empDomain;
	 }
	 
	 public void display(){
		 System.out.println("Employee Id -- " + empId);
		 System.out.println("Employee Name -- " + empName);
		 System.out.println("Employee Domain -- " + empDomain);
	 }
	
}