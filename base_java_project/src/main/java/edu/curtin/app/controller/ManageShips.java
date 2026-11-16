package edu.curtin.app.controller;

import edu.curtin.app.model.Ship;

import java.util.ArrayList;
import java.util.List;

public class ManageShips
{
	private List<Ship> ships; //store all ships

	public ManageShips()
	{
		ships = new ArrayList<>();
	}
	public void AddShip(Ship ship) //add a new ship
	{
		ships.add(ship);
	}
	public void RemoveShip(Ship ship) //remove a ship
	{
		ships.remove(ship);
	}
	public List<Ship> getShips()
	{
		return ships;
	}
	public Ship FindShipByID(String ID) //find a ship by its ID
	{
		for(Ship ship : ships)
		{
			if(ship.getID().equals(ID))
			{
				return ship;
			}
		}
		return null;
	}
	public Ship FindAvailableShips() //finds available ships
	{
		for(Ship ship : ships)
		{
			if(ship.getSeaWorthiness() > 1 && !ship.hasCargo())
			{
				return ship;
			}
		}
		return null;
	}
}




