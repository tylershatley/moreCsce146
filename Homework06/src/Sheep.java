public class Sheep implements Comparable<Sheep>{
	
	private String name;
	private double weight;
	
	//default class
	public Sheep()
	{
		this.name = "bob";
		this.weight = 0.0;
	}
	
	//parameterized class
	public Sheep(String xName, double xWeight)
	{
		this.setName(xName);
		this.setWeight(xWeight);
	}
	
	//acccesors 
	public String getName()
	{
		return this.name;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	//mutators 
	public void setName(String xName)
	{
		this.name = xName;
	}
	
	public void setWeight(double xWeight)
	{
		if(xWeight > 0)
		{
			this.weight = xWeight;
		}
		else
		{
			System.out.println("You have to have a value greater than zero...");
			this.weight = 0;
		}
	}
	
	public String toString()
	{
		return "Name: " + this.name + "\tWeight: " + this.weight;
	}
	
	public int compareTo(Sheep xSheep)
	{		
		if(this.weight < xSheep.getWeight())
			return -1;
		else if(this.weight > xSheep.getWeight())
			return 1;
		else
			return 0;//should never happen.
	}
}

