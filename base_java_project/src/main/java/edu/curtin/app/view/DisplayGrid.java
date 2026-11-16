package edu.curtin.app.view;

import edu.curtin.app.model.Ship;
import edu.curtin.app.model.Position;
import edu.curtin.app.model.Port;
import edu.curtin.app.model.Storm;

import java.util.List;

public class DisplayGrid
{
	private int Width;
	private int Height;
	public DisplayGrid(int Width, int Height)
        {
		this.Width = Width;
	        this.Height = Height;
        }

        public void Display(List<Ship> ships, List<Port> ports, List<Storm> storms, int Hour)
        {
		System.out.print("\033[2J\033[H"); //clear screen
		System.out.flush();

                String[][] grid = EmptyWater();

	        DisplayStorms(grid, storms);
	        DisplayPorts(grid, ports);
	        DisplayShips(grid, ships);

	        PrintGrid(grid);
        }

        private String[][] EmptyWater() //create empty grid with water "~~"
        {
		String[][] grid = new String[Height][Width];

	        for(int y = 0; y < Height; y++)
	        {
			for(int x = 0; x < Width; x++)
		        {
				grid[y][x] = "~~";
		        }
	        } 
	        return grid;
        }

        private void DisplayStorms(String[][] grid, List<Storm> storms) //display storms with "!!"
        {
		for(Storm storm : storms)
	        {
			for(int y = 0; y < Height; y++)
		        {
				for(int x = 0; x < Width; x++)
	                        {
					Position position = new Position(x, y);

				        if(storm.affects(position))
				        {
						grid[y][x] = "!!";
				        }
			        }
		        }
	        }
        }

        private void DisplayPorts(String[][] grid, List<Port> ports) //add ports on the grid 
        {
		for(Port port : ports)
	        {
			int x = port.getPosition().getX();
		        int y = port.getPosition().getY();

		        String ID = formatCell(port.getID());

		        grid[y][x] = ID;
	        }
        }

        private void DisplayShips(String[][] grid, List<Ship> ships) //add ships on the grid
        {
		for(Ship ship : ships)
		{
			int x = ship.getPosition().getX();
		        int y = ship.getPosition().getY();

		        String ID = String.format("%-3s", ship.getID());

		        grid[y][x] = ID;
	        }
        }

        private void PrintGrid(String[][] grid) //print the final grid 
        {
		for(int y = 0; y < Height; y++)
	        {
			for(int x = 0; x < Width; x++)
		        {
				System.out.print(grid[y][x]);
		        }
			System.out.println();
	        }
        }

        private String formatCell(String text) //every cell take same width
        {
		return String.format("%-3s", text);
        }
}




