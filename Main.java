import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Main 
{
	public static ArrayList <Theme> arrayTheme = new ArrayList <Theme>();
	public static ArrayList <Catering> arrayCatering = new ArrayList <Catering>();
	public static ArrayList <Venue> arrayVenue = new ArrayList <Venue>();
	public static ArrayList <Photography> arrayPhotography = new ArrayList <Photography>();
	public static ArrayList <Client> arrayClient = new ArrayList <Client>();
	public static ArrayList <Event> arrayEvent = new ArrayList <Event>();
	public static ArrayList <BookedEvent> arrayBookedEvent = new ArrayList <BookedEvent>(); 
	public static Map <String,String> credentials = new HashMap <String,String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loadData();
					HomePageGUI frame = new HomePageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	static void loadData()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","123");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from theme");
			
			while(rs.next())
			{
				String name = rs.getString(1);
				float f = rs.getFloat(2);
				Theme t = new Theme(name,f);
				Main.arrayTheme.add(t);
			}
			
			rs=stmt.executeQuery("select * from photography");
			while(rs.next())
			{
				String name = rs.getString(1);
				String address = rs.getString(2);
				String email = rs.getString(4);
				String phNo = rs.getString(3);
				float f = rs.getFloat(5);
				Photography t = new Photography(name, address, phNo, email, f);
				Main.arrayPhotography.add(t);
			}
			
			rs=stmt.executeQuery("select * from catering");
			while(rs.next())
			{
				String name = rs.getString(1);
				String address = rs.getString(2);
				String email = rs.getString(3);
				String phNo = rs.getString(4);
				float f = rs.getFloat(5);
				Catering t = new Catering(name, address, phNo, email, f);
				Main.arrayCatering.add(t);
			}
			
			rs=stmt.executeQuery("select * from venue");
			while(rs.next())
			{
				String name = rs.getString(1);
				String address = rs.getString(3);
				String email = rs.getString(2);
				String phNo = rs.getString(4);
				float f = rs.getFloat(5);
				Venue t = new Venue(name, address, phNo, email, f);
				Main.arrayVenue.add(t);
			}
			
			rs=stmt.executeQuery("select * from client");
			while(rs.next())
			{
				String name = rs.getString(1);
				String password = rs.getString(4);
				String email = rs.getString(2);
				String phNo = rs.getString(3);
				Client t = new Client(name, email, phNo, password);
				Main.arrayClient.add(t);
				Main.credentials.put(email, password);
			}
			
			rs=stmt.executeQuery("select * from event");
			while(rs.next())
			{
				String name = rs.getString(1);
				float charges = rs.getFloat(2);
				Event e = new Event(name,charges);
				Main.arrayEvent.add(e);
			}
			
			con.close();
		}catch(Exception e) {System.out.println(e);}
	}

	public static String displayThemeArray()
	{
		String display="";
		for(Theme t : arrayTheme)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String displayEventArray()
	{
		String display="";
		for(Event t : arrayEvent)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String displayVenueArray()
	{
		String display="";
		for(Venue t : arrayVenue)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String displayPhotographyArray()
	{
		String display="";
		for(Photography t : arrayPhotography)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String displayCateringArray()
	{
		String display="";
		for(Catering t : arrayCatering)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String displayClientArray()
	{
		String display="";
		for(Client t : arrayClient)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String displayBookedEventArray()
	{
		String display="";
		for(BookedEvent t : arrayBookedEvent)
		{
			display=display+t.display();
		}
		return display;
	}
	
	public static String[] themeName()
	{
		String[] name = new String[Main.arrayTheme.size()];
		int i = 0; 
		for(Theme t : arrayTheme)
		{
			name[i++]=t.getName();
		}
		return name;
	}
	
	public static String[] photographyName()
	{
		String[] name = new String[Main.arrayPhotography.size()];
		int i = 0; 
		for(Photography t : arrayPhotography)
		{
			name[i++]=t.getName();
		}
		return name;
	}
	
	public static String[] cateringName()
	{
		String[] name = new String[Main.arrayCatering.size()];
		int i = 0; 
		for(Catering t : arrayCatering)
		{
			name[i++]=t.getName();
		}
		return name;
	}
	
	public static String[] venueName()
	{
		String[] name = new String[Main.arrayVenue.size()];
		int i = 0; 
		for(Venue t : arrayVenue)
		{
			name[i++]=t.getName();
		}
		return name;
	}
	
	public static String[] eventName()
	{
		String[] name = new String[Main.arrayEvent.size()];
		int i = 0; 
		for(Event t : arrayEvent)
		{
			name[i++]=t.getName();
		}
		return name;
	}

	public static boolean validateUser(String email, String password)
	{
		if(Main.credentials.get(email).equals(password))
			return true;
		else
			return false;
	}
	
	public static Client getClient(int index)
	{
		return Main.arrayClient.get(index);
	}
}
