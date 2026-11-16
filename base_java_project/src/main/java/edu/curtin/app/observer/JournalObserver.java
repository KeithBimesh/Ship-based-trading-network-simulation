package edu.curtin.app.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JournalObserver implements Observer
{
	private PrintWriter writer;

	public JournalObserver(String filename) //this writes all events to journal.txt file
	{
		try
		{
			writer = new PrintWriter(new FileWriter(filename, true));
		}
		catch(IOException e)
		{
			throw new RuntimeException("Can't open journal file", e);
		}
	}

	@Override
	public void update(String Event)
	{
		writer.println(Event);
		writer.flush();
	}

	public void close() //close the file 
	{
		writer.close();
	}
}

