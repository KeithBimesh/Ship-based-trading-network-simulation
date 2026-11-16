package edu.curtin.app.factory;

import edu.curtin.app.model.Position;
import edu.curtin.app.model.Ship;

public class ShipFactory
{
	public static Ship createShip(String ID, int x, int y) //creates a new ship
	{
		return new Ship(ID, new Position(x, y));
	}
}
