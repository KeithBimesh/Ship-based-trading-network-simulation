package edu.curtin.app.factory;

import edu.curtin.app.model.Cargo;

public class CargoFactory
{
	public static Cargo createCargo(int Size, String Type, String Origin, String Destination) //creates a cargo
	{
		return new Cargo(Size, Type, Origin, Destination);
	}
}

