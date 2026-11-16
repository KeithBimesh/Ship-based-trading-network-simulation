package edu.curtin.app.state;

import edu.curtin.app.model.Ship;

public class UnloadState implements ShipState
{
	private int RemainingTime = 5;

	@Override
	public void update(Ship ship)
	{	
		RemainingTime--;

		if(RemainingTime <= 0)
	        {
			ship.setCargo(null); //after unload, remove the cargo
		        ship.setState(new IdleState()); //go to idle state
	        }
	}

	@Override
	public String getName()
	{
		return "Unloading"; //return name for display
	}
}
