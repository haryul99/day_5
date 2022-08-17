package haryul;

public class Vo {
	// 매핑
	private String id;
	private String name;
	private String birthday;
	private String deleteha;
	
	public Vo() {};
	
	public Vo(String id, String name, String birthday, String deleteha) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.deleteha = deleteha;
	}
	
	public String GetId() {
		return id;
	}
	public String GetName() {
		return name;
	}
	public String GetBirthday() {
		return birthday;
	}
	public String GetDeleteha() {
		return deleteha;
	}
	
	public void SetId(String id) {
		this.id = id;
	}
	public void SetName(String name) {
		this.name = name;
	}
	public void SetBirthday(String birthday) {
		this.birthday= birthday;
	}
	public void SetDeleteha(String deleteha) {
		this.deleteha = deleteha;
	}
	
	
	
	public static void PrintVo(Vo vo) {
		System.out.println("id >>>" + vo.GetId());
		System.out.println("name >>>" + vo.GetName());
		System.out.println("birthday >>>" + vo.GetBirthday());
		System.out.println("deleteha >>>" + vo.GetDeleteha());
	}
	

}
