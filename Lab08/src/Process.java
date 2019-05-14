/*
 * Tyler Shatley
 * csce 146
 * lab08
 */
public class Process implements Comparable <Process> {
	
	private int priority;
	private double time;
	private String name;
	

	public int getPriority() 
	{
		return priority;
	}

	public void setPriority(int xPriority) 
	{
		if(xPriority > 0)
		{
			this.priority = xPriority;
		}
		else
		{
			System.out.println("You cant have a negative value");
			this.time = 1;
		}
	}

	public double getTime() 
	{
		return time;
	}

	public void setTime(double xTime) 
	{
		if(xTime > 0)
		{
			this.time = xTime;
		}
		else
		{
			System.out.println("You cant have a negative value");
			this.time = 1;
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String xName) 
	{
		this.name = xName;
	}
	
	//default 
	public Process()
	{
		this.priority = 1;
		this.time = 1.0;
		this.name = "no";
	}
	
	//parametrized
	public Process(String xName, int xPriority, double xTime)
	{
		this.setPriority(xPriority);
		this.setTime(xTime);
		this.setName(xName);
	}
	
	public String toString()
	{
		return "Name: " + this.name + " Time: " + this.time + " Priority: " + this.priority;
	}
	
	public int compareTo(Process xProcess)
	{
		if(this.priority < xProcess.getPriority())
			return -1;
		else if(this.priority > xProcess.getPriority())
			return 1;
		else
			return 0;
	}
}
