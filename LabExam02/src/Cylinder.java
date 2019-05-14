/*
 * Tyler Shatley
 * csce 146
 */
public class Cylinder implements Comparable<Cylinder> {
	
	private double baseRadius;
	private double height;
	
	
	//defualt
	public Cylinder()
	{
		this.baseRadius = 0.1;
		this.height = 0.1;
	}
	
	public Cylinder(double xBaseRadius, double xHeight)
	{
		this.setBaseRadius(xBaseRadius);
		this.setHeight(xHeight);
	}
//x*height*br^2
	
	public double getBaseRadius() 
	{
		return baseRadius;
	}


	public void setBaseRadius(double xBaseRadius) 
	{
		if(xBaseRadius >= 0)
		{
			this.baseRadius = xBaseRadius;
		}
		else
		{
			System.out.println("you cant have a negative number.");
			this.baseRadius = 0.1;
		}
	}


	public double getHeight() 
	{
		return height;
	}


	public void setHeight(double xHeight) 
	{
		if(xHeight >= 0)
		{
			this.height = xHeight;
		}
		else
		{
			System.out.println("you cant have a negative nubmer.");
			this.height = 0;
		}
	}
	
	public double getVolume() //i think the formula for volume is pi *height*br^2?
	{
		return Math.PI*this.height*(this.baseRadius*this.baseRadius);
	}
	
	
	public int compareTo(Cylinder xCylinder)
	{
		if(this.getVolume() < xCylinder.getVolume())
			return -1;
		else if(this.getVolume() > xCylinder.getVolume())
			return 1;
		else 
			return 0;		
	}
}
