package edu.curtin.app.state;

import edu.curtin.app.model.Ship;

public class IdleState implements ShipState 
{
	@Override
	public void update(Ship ship)
	{
		//no action when idle

	}

	@Override
	public String getName()
	{
		return "Neither"; //return name for display
	}
}
