abstract public class Services 
{
	int serviceId;
	String serviceName;
	
	Services(int id,String name)
	{
		serviceId=id;
		serviceName=name;
	}	
	
	abstract public String display();
}
