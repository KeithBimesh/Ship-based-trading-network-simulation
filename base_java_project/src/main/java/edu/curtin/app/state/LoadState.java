package edu.curtin.app.state;

import edu.curtin.app.model.Ship;
import edu.curtin.app.observer.ManageEvents;

public class LoadState implements ShipState
{
	private int RemainingTime = 5;
	private ManageEvents manageEvents;

	public LoadState(ManageEvents manageEvents)
	{
		this.manageEvents = manageEvents;
	}
	
	@Override
	public void update(Ship ship)
	{
		RemainingTime--;

		if(RemainingTime <= 0)
		{
			ship.setState(new IdleState()); //after load ship go to idle state
		}
	}

	@Override
	public String getName()
	{
		return "Loading"; //return name for display
	}
}
