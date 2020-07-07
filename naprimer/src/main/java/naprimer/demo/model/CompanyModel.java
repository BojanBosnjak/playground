package naprimer.demo.model;

public class CompanyModel {
	private Integer id;
	private String name;
	private final int authority = 1;
	private EmployeeModel employeeModel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAuthority() {
		return authority;
	}
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}
	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
	
	public void setEmployeeAuthority(int authority) {
		employeeModel.setAuthority(authority);
	}
	
}
