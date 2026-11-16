package edu.curtin.app.state;

import edu.curtin.app.model.Ship;
import edu.curtin.app.model.Position;

public class MoveState implements ShipState
{
	private Position Target;

	public MoveState(Position Target)
	{
		this.Target = Target;
	}

	@Override
	public void update(Ship ship)
	{
		Position position = ship.getPosition();

		int x = position.getX();
		int y = position.getY();

		if(x < Target.getX()) //move toward target x
		{
			x++;
		}
		else if(x > Target.getX())
		{
			x--;
		}

		if(y < Target.getY()) //move toward target y
		{
			y++;
		}
		else if(y > Target.getY())
		{
			y--;
		}

		ship.setPosition(new Position(x, y));
	}

	@Override
	public String getName()
	{
		return "Moving";
	}
}
