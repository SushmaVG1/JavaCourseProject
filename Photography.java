public class Photography extends Services
{
	String name;
	String address;
	String phNo;
	String email;
	float charges;
	
	Photography(String n, String a, String p, String e, float c)
	{
		super(2,"Photography");
		name=n;
		address=a;
		phNo=p;
		email=e;
		charges=c;
	}
	
	public String display()
	{
		return "***\n" + "Name : " + name + "\nAddress : " + address + "\nPhone No. : " 
				+ phNo + "\nEmail ID : " + email + "\nCharges : Rs. " + charges + "\n***\n"; 			
	}
	
	public String getName()
	{
		return name;
	}
	
	public Photography getPhotography()
	{
		return this;
	}
}
