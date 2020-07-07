package naprimer.demo.model;

public class UserModel {
	private Integer id;
	private String name;
	private final int authority = 3;
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
	
}
