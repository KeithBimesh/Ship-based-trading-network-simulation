package edu.curtin.app.model;

import edu.curtin.app.state.ShipState;
import edu.curtin.app.state.IdleState;

public class Ship
{
	private String ID;
	private Position position;
	private int SeaWorthiness;
	private ShipState state;
	private Cargo cargo;
	private boolean hasArrivedToPort = false;

	public Ship(String ID, Position position)
	{
		this.ID = ID;
		this.position = position;
		this.SeaWorthiness = 4;
		this.state = new IdleState();
		this. cargo = null;
	}

	public String getID() //getters
	{
		return ID;
	}
	public Position getPosition() //getters
	{
		return position;
	}
	public void setPosition(Position position) //getters
	{
		this.position = position;
	}
	public int getSeaWorthiness() //getters
	{
		return SeaWorthiness;
	}
	public ShipState getState() //getters
	{
		return state;
	}

	public void setState(ShipState state) //setter
	{
		this.state = state;
	}
	public Cargo getCargo() //getters
	{
		return cargo;
	}
	public void setCargo(Cargo cargo) //setters
	{
		this.cargo = cargo;
	}
	public void Update()
	{
		state.update(this);
	}
	public void increaseSeaWorthiness(int value) //increase sea worthiness
	{
		this.SeaWorthiness = SeaWorthiness + value;
		if(SeaWorthiness > 4)
		{
			SeaWorthiness = 4; //maximum sea worthiness is 4
		}
	}
	public void decreaseSeaWorthiness(int value) //decrease sea worthiness 
	{
		this.SeaWorthiness = SeaWorthiness - value;
	}
	public boolean hasCargo() //check whether ship has a cargo
	{
		return cargo != null;
	}
	public boolean isDisabled()
	{
		return SeaWorthiness <= 1;
	}
	public boolean atPort() //check whether ship at port
	{
		return true;
	}
	public boolean hasArrivedToPort()
	{
		return hasArrivedToPort;
	}
	public void setHasArrivedToPort(boolean value)
	{
		hasArrivedToPort = value;
	}

	public String toString()
	{
		return "Ship ID - " + ID +
		       "Position - " + position +
		       "Sea worthiness - " + SeaWorthiness +
		       "Cargo - " + cargo;
	}
}
