package edu.curtin.app.state;

import edu.curtin.app.model.Ship;

public class ShipRepairState implements ShipState
{
	private int RemainingTime = 5;
	private Ship TargetShip;

	public ShipRepairState(Ship TargetShip)
	{
		this.TargetShip = TargetShip;
	}

	@Override
	public void update(Ship ship)
	{
		RemainingTime--;
		
		if(RemainingTime <= 0) //complete repair
		{
			TargetShip.increaseSeaWorthiness(3); //increase sea worthiness of target ship

			ship.setState(new IdleState()); //repairing ship go to idle state
		}
	}

	@Override
	public String getName()
	{
		return "Repairing";
	}
}
