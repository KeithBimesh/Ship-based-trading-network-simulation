package edu.curtin.app.model;

public class Cargo
{
	private int Size;
	private String Type;
	private String Origin;
	private String Destination;

	public Cargo(int Size, String Type, String Origin, String Destination) //constructor
	{
		this.Size = Size;
		this.Type = Type;
		this.Origin = Origin;
		this.Destination = Destination;
	}
	public int getSize() //getters
	{
		return Size;
	}
	public String getType() //getters
	{
		return Type;
	}
	public String getOrigin() //getters
	{
		return Origin;
	}
	public String getDestination() //getters
	{
		return Destination;
	}
	public void setSize(int Size) //setters
	{
		this.Size = Size;
	}
	public void setType(String Type) //setters
	{
		this.Type = Type;
	}
	public void setOrigin(String Origin) //setters
	{
		this.Origin = Origin;
	}
	public void setDestination(String Destination) //setters
	{
		this.Destination = Destination;
	}

	public String toString()
	{
		return "Cargo - Size: " + Size +
			      " Type: " + Type + 
			      "Origin: " + Origin +
			      "Destination: " + Destination;
	}
}
