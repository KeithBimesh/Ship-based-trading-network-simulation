package edu.curtin.app.factory;

import edu.curtin.app.model.Port;
import edu.curtin.app.model.Position;

public class PortFactory
{
	public static Port createPort(String ID, int x, int y) //creates a port
	{
		return new Port(ID, new Position(x, y));
	}
}

