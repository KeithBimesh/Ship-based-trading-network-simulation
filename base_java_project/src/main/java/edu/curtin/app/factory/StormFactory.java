package edu.curtin.app.factory;

import edu.curtin.app.model.Position;
import edu.curtin.app.model.Storm;

public class StormFactory
{
	public static Storm createStorm(int x, int y, int radius) //creates a storm at a given position, and with radius
	{
		return new Storm(new Position(x, y), radius);
	}
}
