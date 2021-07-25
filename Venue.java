public class Venue extends Services
{
	String name;
	String address;
	String phNo;
	String email;
	float charges;
	
	Venue(String n, String a, String p, String e, float c)
	{
		super(4,"Venue");
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
	
	public Venue getVenue()
	{
		return this;
	}
}
