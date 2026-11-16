package edu.curtin.app.model;

public class Position
{
	private int x;
	private int y;

	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX() //getters
	{
		return x;
	}

	public int getY() //getters
	{
		return y;
	}

	public void setX(int x) //setters
	{
		this.x = x;
	}

	public void setY(int y) //setters
	{
		this.y = y;
	}

	public String toString()
	{
		return " ( " + x + "," + y + " ) ";
	}
}	
