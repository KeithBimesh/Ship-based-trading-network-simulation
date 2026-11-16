package edu.curtin.app.controller;

import edu.curtin.app.model.*;
import edu.curtin.app.state.*;
import edu.curtin.app.observer.ManageEvents;
import edu.curtin.app.factory.*;
import edu.curtin.app.view.DisplayGrid;
import edu.curtin.oose.assignment2.Scenario;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.ArrayList;
import java.util.List;

public class Simulation
{
	private final ManageEvents manageEvents;
	private final Movement movement;
	private final ManageShips manageShips;
	private final StormController stormController;
	private final RepairController repairController;
	private final DisplayGrid displayGrid;

	private final List<Port> ports; //stores all ports
        private final List<Storm> storms; //stores storms
	private Scenario scenario;
	
	private int CurrentHour = 0;

	private static final Logger logger = Logger.getLogger(Simulation.class.getName());

	public Simulation(Scenario scenario, ManageEvents manageEvents, DisplayGrid displayGrid) //constructor
	{
		this.scenario = scenario;
		this.manageEvents = manageEvents;
		this.displayGrid = displayGrid;
		this.movement = new Movement(manageEvents);
		this.manageShips = new ManageShips();
		this.stormController = new StormController(manageEvents);
		this.repairController = new RepairController(manageEvents, manageShips);
		this.ports = new ArrayList<>();
		this.storms = new ArrayList<>();
	}

	public void simulate()
	{
	
		manageEvents.notifyObservers("Hour: " + CurrentHour);
		
		String Message;

		while((Message = scenario.nextMessage()) != null) //process scenario messsage
		{
			HandleMessage(Message);
		}

		movement.UpdateShips(manageShips.getShips(), ports); //update ship movements
		stormController.ApplyStorms(manageShips.getShips(), storms, ports); //apply storm
		repairController.Repair(manageShips.getShips()); //handle repairing of damaged ships
		displayGrid.Display(manageShips.getShips(), ports, storms, CurrentHour); //display grid

		storms.clear();
		CurrentHour++;

	}

	private void HandleMessage(String Message)
	{
		if(Message == null || Message.isBlank()) //ignore null and empty messages
		{
			return;
		}

		String[] parts = Message.split(" ");

		switch(parts[0])
		{
			case "ship":
				createShip(parts);
				break;

			case "port":
				createPort(parts);
				break;

			case "storm":
				createStorm(parts);
				break;

			case "supply":
				createSupply(parts);
				break;

			default:
				manageEvents.notifyObservers("Invalid message" + Message);
		}
	}

	private void createShip(String[] parts) //create a ship
	{
		if(parts.length < 4)
		{
			logger.log(Level.WARNING, "Invalid Ship message");
			return;
		}
		try
		{
			//create ship using factory
			Ship ship = ShipFactory.createShip(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

		        manageShips.AddShip(ship);
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.WARNING, "Invalid port coordinates");
			return;
		}
	}

	private void createPort(String[] parts) //create a port 
	{
		if(parts.length < 4)
		{
			logger.log(Level.WARNING, "Invalid Port message");
			return;
		}
		try
		{
			//create port using factory
			Port port = PortFactory.createPort(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

                        ports.add(port);
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.WARNING, "Invalid port");
			return;
		}
	}

	private void createStorm(String[] parts) //create a storm
	{
		if(parts.length < 4)
		{
			logger.log(Level.WARNING, "Invalid Storm message");
			return;
		}
		try
		{
			//create storm using factory
			Storm storm = StormFactory.createStorm(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

		        storms.add(storm);
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.WARNING, "Invalid storm message", e);
		}
	}

	private void createSupply(String[] parts) //assign cargo to ship
	{
		if(parts.length < 5)
		{
			logger.log(Level.WARNING, "Invalid supply message");
			return;
		}
		Ship ship = manageShips.FindAvailableShips();

		if(ship == null)
		{
			manageEvents.notifyObservers("Supply ignored");
			return;
		}
		try
		{
			Cargo cargo = CargoFactory.createCargo(Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);

		        ship.setCargo(cargo); //assign cargo to ship

			Port destinationPort = findPortByID(parts[4]); //find destination port

			ship.setState(new MoveState(destinationPort.getPosition())); //changed ship's state(move to destination port)

		        manageEvents.notifyObservers("Ship " + ship.getID() + " assigned cargo ");
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.WARNING, "invalid supply size" + parts[1], e);
		}
		catch(Exception e)
		{
			logger.log(Level.SEVERE, "unexpected error in createSupply()", e);
		}
	}
	private Port findPortByID(String ID) //find a port by its ID
	{
		for(Port port : ports)
		{
			if(port.getID().equals(ID))
			{
				return port;
			}
		}
		return null;
	}

	
}
