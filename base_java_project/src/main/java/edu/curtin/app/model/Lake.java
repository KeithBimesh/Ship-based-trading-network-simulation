package edu.curtin.app.model;

public class Lake
{
	private int Width;
	private int Height;

	public Lake(int Width, int Height)
	{
		this.Width = Width;
		this.Height = Height;
	}
	public int getWidth() //getters
	{
		return Width;
	}
	public int getHeight() //getters
	{
		return Height;
	}
	public boolean InsideLake(Position p) //Check whether inside the grid
	{
		return p.getX() >= 0 && p.getX() < Width && p.getY() >= 0 && p.getY() < Height;
	}
}

