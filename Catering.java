public class Catering extends Services
{
	String name;
	String address;
	String phNo;
	String email;
	float charges;
	
	Catering(String n, String a, String p, String e, float c)
	{
		super(1,"Catering");
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
	
	public Catering getCatering()
	{
		return this;
	}
}
