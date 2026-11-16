package edu.curtin.app.model;

public class Port
{
	private String ID;
	private Position position;

	public Port(String ID, Position position)
	{
		this.ID = ID;
		this.position = position;
	}

	public String getID() //getters
	{
		return ID;
	}
	public void setID(String ID) //getters
	{
		this.ID = ID;
	}
	public Position getPosition() //getters
	{
		return position;
	}
	public void setPosition(Position position) //setters
	{
		this.position = position;
	}

	public String toString()
	{
		return "Port ID - " + ID +
		       "Position - " + position;
	}
}
