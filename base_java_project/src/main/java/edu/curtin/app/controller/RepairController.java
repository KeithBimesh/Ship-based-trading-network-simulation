package edu.curtin.app.controller;

import edu.curtin.app.model.Ship;
import edu.curtin.app.observer.ManageEvents;
import edu.curtin.app.state.MoveState;
import edu.curtin.app.state.ShipRepairState;

import java.util.List;

public class RepairController
{
	private ManageEvents manageEvents;
	private ManageShips manageShips;

	public RepairController(ManageEvents manageEvents, ManageShips manageShips)
	{
		this.manageEvents = manageEvents;
		this.manageShips = manageShips;
	}

	public void Repair(List<Ship> ships)
	{
		for(Ship DamagedShip : ships)
		{
			if(DamagedShip.getSeaWorthiness() == 1) //check ship is damaged
			{
				Ship helpingShip = manageShips.FindAvailableShips(); //find available ship to repair damaged ship

				if(helpingShip != null)
			        {
					helpingShip.setState(new MoveState(DamagedShip.getPosition()));

				        manageEvents.notifyObservers("Ship " + helpingShip.getID() + "assigned to repair ship" + DamagedShip.getID()); //log repair ship assignment
			        }
		        }
	        }
        }
}



