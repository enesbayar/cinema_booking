package Model;

public class Admin {
	private String userName;
	private String password;
	
	public Admin(String userName, String password){
		this.userName = userName;
		this.password= password;
	}
	public Admin(){
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
