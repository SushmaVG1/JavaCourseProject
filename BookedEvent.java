import java.util.*;

public class BookedEvent 
{
	Event event;
	Venue venue;
	Photography photography;
	Catering catering;
	Theme theme;
	Date date;
	float totalCharges;
	
	BookedEvent(Event e, Venue v, Photography p, Catering c, Theme t, Date d)
	{
		event = e;
		venue = v;
		photography = p;
		catering = c;
		theme = t;
		date = d;
		totalCharges = e.charges + v.charges + p.charges + c.charges + t.charges;
	}
	
	public String display()
	{
		return ("\nEVENT \n" + event.display() + "VENUE \n" + venue.display() + "PHOTOGRAPHY \n" + photography.display() + 
				"CATERING \n" + catering.display() + "THEME \n" + theme.display() +
				"EVENT DATE : " + date.toString() + "\n***" + "\nTotal Charges = Rs. " + totalCharges);
	}
	
	public String display(int a)
	{
		return ("EVENT DATE : " + date.toString() + "\n***" +
		"\nTotal Charges = Rs. " + totalCharges);
	}
}
