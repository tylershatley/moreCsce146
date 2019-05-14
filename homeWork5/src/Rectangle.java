/*
 * Tyler Shatley 
 * csce146
 * hw05
 */
public class Rectangle implements Shape {
	
	private String type;
	private double side1;
	private double side2;
	
	//default
	public Rectangle()
	{
		this.type = "none";
		this.side1 = 0.0;
		this.side2 = 0.0;
	}
	
	//parametrized 
	public Rectangle(String xType, double xSide1, double xSide2)
	{
		this.setType(xType);
		this.setSide1(xSide1);
		this.setSide2(xSide2);
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public double getSide1()
	{
		return this.side1;
	}
	
	public double getSide2()
	{
		return this.side2;
	}
	
	public double getArea()
	{
		return (this.side1*this.side2);
	}
	
	public void setType(String xType)
	{
		this.type = xType;
	}
	
	public void setSide1(double xSide1)
	{
		if(xSide1 > 0)
		{
			this.side1 = xSide1;
		}
		else
		{
			System.out.println("You cant have a negative value");
			this.side1 = xSide1;
		}
	}
	
	public void setSide2(double xSide2)
	{
		if(xSide2 > 0)
		{
			this.side2 = xSide2;
		}
		else
		{
			System.out.println("You cant have a negative value");
		}
	}
	
	public String toString()
	{
		return this.type + " Side 1: " + this.side1 + " Side 2: " + this.side2 + " Area: " + getArea();
	}

}
