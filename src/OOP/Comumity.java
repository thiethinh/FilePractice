package OOP;

public class Comumity {

	private String name;
	private int numbMember;
	protected Comumity(String name, int numbMember) {
		super();
		this.name = name;
		this.numbMember = numbMember;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumbMember() {
		return numbMember;
	}
	public void setNumbMember(int numbMember) {
		this.numbMember = numbMember;
	}
	
	
}
