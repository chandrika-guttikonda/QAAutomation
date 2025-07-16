package tests.Day13_AccessModifiersStaticFinalUsage;

public class Employee {
	private int id;
	private String name;
	private int salary;
	static final String Company="ABC Technologies";
	public Employee() {
		this.id=123;
		this.name="Chandrika";
		this.salary=500000;
	}
	public Employee(int id,String name,int salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}

}
