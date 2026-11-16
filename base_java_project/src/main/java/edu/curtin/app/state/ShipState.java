package edu.curtin.app.state;

import edu.curtin.app.model.Ship;

public interface ShipState
{
	void update(Ship ship);

	String getName();
}
