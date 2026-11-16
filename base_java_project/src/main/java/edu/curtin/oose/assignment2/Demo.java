package edu.curtin.oose.assignment2;

import edu.curtin.app.controller.Simulation;
import edu.curtin.app.observer.ManageEvents;
import edu.curtin.app.observer.JournalObserver;
import edu.curtin.app.view.DisplayGrid;
import java.util.logging.Logger;
import java.util.logging.Level;

/*
 * Use this code to get started on Assignment 2. You are free to modify or replace this file as
 * needed (to fulfil the assignment requirements, of course).
 */
public class Demo
{
	private static final Logger logger = Logger.getLogger(Demo.class.getName());
    public static void main(String[] args)
    {
	    try
	    {
		    Scenario scenario = new Scenario(); //create scenario generator

	            System.out.println("Width = " + scenario.getWidth() + " Height = " + scenario.getHeight());

	            ManageEvents manageEvents = new ManageEvents(); //create manage evenets

	            JournalObserver journalObserver = new JournalObserver("journal.txt"); //create journal observer to log events to journal.txt

	            manageEvents.addObserver(journalObserver); //register observer to get events

	            DisplayGrid displayGrid = new DisplayGrid(scenario.getWidth(), scenario.getHeight()); //create display grid

	            Simulation simulation = new Simulation(scenario, manageEvents, displayGrid); //create simulation

	            while(System.in.available() == 0) //main simulation loop
	            {
			    simulation.simulate();
		            Thread.sleep(1000);
	            }

	            journalObserver.close();
	    }
	    catch(Exception e)
	    {
		    logger.log(Level.WARNING, "Invalid data", e);
	    }
    }
}
