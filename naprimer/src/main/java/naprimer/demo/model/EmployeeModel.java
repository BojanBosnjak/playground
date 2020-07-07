package naprimer.demo.model;


public class EmployeeModel {
	private Integer id;
	private String name;
	private int authority;
	private int company;
	/*Authority employee-u moze da postavlja sam company i moze da ga psotavi da bude 
	 * 2 ili 5. 
	 */
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
	public void setAuthority(int authority) {
		
		this.authority = authority;
	}

	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	
	

	
}
