/*
 * Tyler Shatley
 * csce146
 * Hw05
 */
public class Circle implements Shape{
	
	private String type;
	private double radius;
	
	//deafult class
	public Circle()
	{
		this.type = "none";
		this.radius = 0.0;
	}
	
	//parametrized constructor
	public Circle(String xType, double xRadius)
	{
		this.setType(xType);
		this.setRadius(xRadius);
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public double getArea()
	{
		return Math.PI*(this.radius*this.radius);
	}
	
	public void setType(String xType)
	{
		this.type = xType;
	}
	
	public void setRadius(double xRadius)
	{
		if(xRadius >=0)
		{
			this.radius = xRadius;
		}
		else
		{
			System.out.println("You cant have a negative value");
			this.radius = 0;
		}
	}
	
	public String toString()
	{
		return this.type + " Radius: " + this.radius + " Area: " + getArea();
	}
	
}
