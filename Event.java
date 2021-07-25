public class Event {
	String name;
	float charges;
	
	Event(String n, float c)
	{
		name=n;
		charges=c;
	}
	
	public String display()
	{
		return "***\n" + "Event : " + name + "\nCharges : Rs. " + charges + "\n***\n";
	}
	
	public String getName()
	{
		return name;
	}
	
	public Event getEvent()
	{
		return this;
	}
}
