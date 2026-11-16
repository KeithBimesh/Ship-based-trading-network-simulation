package edu.curtin.app.model;

public class Storm
{
	private Position Center;
	private int Radius;

	public Storm(Position Center, int Radius)
	{
		this.Center = Center;
		this.Radius = Radius;
	}

	public Position getCenter()
	{
		return Center;
	}
	public void setCenter(Position Center)
	{
		this.Center = Center;
	}
        public int getRadius()
	{
	        return Radius;
	}
        public void setRadius(int Radius)
	{
	        this.Radius = Radius;
	}
	public boolean affects(Position p) //check whether storm affected to a given position
	{
		int dx = Center.getX() - p.getX();
		int dy = Center.getY() - p.getY();
		return (dx * dx  + dy * dy) <= (Radius * Radius);
	}
	public String toString()
	{
		return "Storm - Center: " + Center + " Radius: " + Radius;
	}	       	
}	
