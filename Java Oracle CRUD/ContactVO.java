package j20240826.contact;

// 도메인 클래스
// DB테이블의 칼럼과 1:1 매핑됨
public class ContactVO {
	private int no; // NUMBER
	private String name; // VARCHAR2(20)
	private String phoneNumber; // CHAR(16)
	private String email; // VARCHAR2(100)
	
	ContactVO(int no, String name, String phoneNumber, String email) {
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactVO [no=" + no + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	
	
}
