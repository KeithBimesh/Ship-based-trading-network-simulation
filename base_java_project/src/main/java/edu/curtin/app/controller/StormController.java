package edu.curtin.app.controller;

import edu.curtin.app.model.*;
import edu.curtin.app.factory.ShipFactory;
import edu.curtin.app.observer.ManageEvents;

import java.util.List;

public class StormController
{
	private ManageEvents manageEvents;

	public StormController(ManageEvents manageEvents)
	{
		this.manageEvents = manageEvents;
	}

	public void ApplyStorms(List<Ship> ships, List<Storm> storms, List<Port> ports)
	{
		for(int i = 0; i < ships.size(); i++)
		{
			Ship ship = ships.get(i);

			for(Storm storm : storms)
			{
				if(storm.affects(ship.getPosition())) //check storm affects to ship position
				{
					ship.decreaseSeaWorthiness(1); //decrease sea worthiness

					String result = "";

					if(ship.getSeaWorthiness() <= 0)
					{
						result = ("Ship " + ship.getID() + " sunk"); //if sea worthiness <= 0, ship sunk
					}

					else if(ship.getSeaWorthiness() == 1)
					{
						result = ("Ship " + ship.getID() + " disabled"); //if sea worthiness = 1, ship disabled
					
					}

                                        //log stom impact
	                        	manageEvents.notifyObservers("Ship " + ship.getID() + " hit by storm " + " , Sea worthiness : " + ship.getSeaWorthiness() + " " + result);

					if(ship.getSeaWorthiness() <= 0)
					{
						ships.remove(i);
						
						i--;

					        String NewID = Integer.toString(ships.size() + 100);

						//creare replacement ship
					        Ship NewShip = ShipFactory.createShip(NewID, ports.get(0).getPosition().getX(), ports.get(0).getPosition().getY());

					        ships.add(NewShip);

					        manageEvents.notifyObservers("Created replacement ship " + NewID + " at port " + ports.get(0).getID()); //log replacement ship creation
					}

				        break;
				}
			}
		}
	}
}	
