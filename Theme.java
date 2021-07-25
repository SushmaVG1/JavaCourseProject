public class Theme extends Services
{
	String name;
	float charges;
	
	Theme(String n, float c)
	{
		super(3,"Theme");
		name=n;
		charges=c;
	}
	
	public String display()
	{
		return("***" + "\nName : " + name + "\nCharges : Rs. " + charges + "\n***\n");
	}
	
	public String getName()
	{
		return name;
	}
	
	public Theme getTheme()
	{
		return this;
	}
}
