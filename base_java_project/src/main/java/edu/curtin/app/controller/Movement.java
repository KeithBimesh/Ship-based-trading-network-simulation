package edu.curtin.app.controller;

import edu.curtin.app.model.*;
import edu.curtin.app.observer.ManageEvents;
import edu.curtin.app.state.MoveState;
import edu.curtin.app.state.LoadState;
import edu.curtin.app.state.UnloadState;
import edu.curtin.app.state.IdleState;

import java.util.List;

public class Movement
{
	private ManageEvents manageEvents;

	public Movement(ManageEvents manageEvents)
	{
		this.manageEvents = manageEvents;
	}

	public void UpdateShips(List<Ship> ships, List<Port> ports) //update all ships
	{
		for(Ship ship : ships)
		{
		        Position OldPosition = new Position(ship.getPosition().getX(), ship.getPosition().getY()); //store the previous position

			ship.Update(); //ship update according to state

		        Position NewPosition = ship.getPosition(); //get new position

			if(OldPosition.getX() != NewPosition.getX() || OldPosition.getY() != NewPosition.getY()) //check position has changed
			{
				manageEvents.notifyObservers(" Ship " + ship.getID() + " moved to ( " + NewPosition.getX() + "," + NewPosition.getY() + ")"); //log movement
			}

			boolean inPort = false;

			for(Port port : ports)
			{
				Position ShipPosition = ship.getPosition();
				Position PortPosition = port.getPosition();
				if(ShipPosition.getX() == PortPosition.getX() && ShipPosition.getY() == PortPosition.getY())
				{
					inPort = true;

					ship.increaseSeaWorthiness(4); //increase sea worthiness

					if(ship.getCargo() == null) //find ship's state
					{
						ship.setState(new IdleState());
					}
					else
					{
						if(port.getID().equals(ship.getCargo().getDestination()))
						{
							ship.setState(new UnloadState());
						}
						else
						{
							ship.setState(new LoadState(manageEvents));
						}
					}

					if(!ship.hasArrivedToPort()) //when visit log arrival
					{
						ship.setHasArrivedToPort(true);

						String cargo = "";
						
						if(ship.getCargo() != null)
						{
							cargo = ship.getCargo().getType();
						}

					        manageEvents.notifyObservers("Ship " + ship.getID() + " arrived to " + port.getID() + " , " + ship.getState().getName() + ", Cargo: " + cargo);
	          			}

					break;
				}   		
			}
			if(!inPort) //reset arrival after ship leave
			{
				ship.setHasArrivedToPort(false);
			}

		}
	}
}	

