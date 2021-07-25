public class Client 
{
	String name;
	String email;
	String phNo;
	String password;
	
	Client(String name, String emailId, String phNo, String pw)
	{
		this.name = name;
		email = emailId;
		this.phNo = phNo;
		password = pw;
	}
	
	public String display()
	{
		return "***\n" + "Name : " + name + "\nPhone No. : " 
				+ phNo + "\nEmail ID : " + email + "\n***\n"; 
	}
	
}
