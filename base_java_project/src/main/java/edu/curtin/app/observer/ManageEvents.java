package edu.curtin.app.observer;

import java.util.ArrayList;
import java.util.List;

public class ManageEvents implements Subject
{
	private List<Observer> observers = new ArrayList<>();

	@Override
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String Event) //send notification to all observers, this used to logging
	{
		for(Observer obs : observers)
		{
			obs.update(Event);
		}
	}
}

