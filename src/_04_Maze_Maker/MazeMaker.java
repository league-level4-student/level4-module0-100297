package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		selectNextPath(maze.cells[randGen.nextInt(width)][randGen.nextInt(height)]);
		// 5. call selectNextPath method with the randomly selected cell

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell
		if (MazeMaker.getUnvisitedNeighbors(currentCell).size() < 1) {
			int wCell = randGen.nextInt(MazeMaker.getUnvisitedNeighbors(currentCell).size());
			uncheckedCells.push(MazeMaker.getUnvisitedNeighbors(currentCell).get(wCell));
			if (getUnvisitedNeighbors(currentCell).get(wCell)
					.equals(maze.cells[currentCell.getX() + 1][currentCell.getY()])) {
				currentCell.setWestWall(false);
			}
			if (getUnvisitedNeighbors(currentCell).get(wCell)
					.equals(maze.cells[currentCell.getX() - 1][currentCell.getY()])) {
				currentCell.setEastWall(false);
			}
			if (getUnvisitedNeighbors(currentCell).get(wCell)
					.equals(maze.cells[currentCell.getX() + 1][currentCell.getY()])) {
				currentCell.setSouthWall(false);
			}
		}

		// C. if has unvisited neighbors,

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and mark it as visited

		// D. if all neighbors are visited

		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {

	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> a = new ArrayList<Cell>();
		if (maze.cells[c.getX() + 1][c.getY()].hasBeenVisited()) {
			a.add(maze.cells[c.getX() + 1][c.getY()]);
		}
		if (maze.cells[c.getX()][c.getY() + 1].hasBeenVisited()) {
			a.add(maze.cells[c.getX()][c.getY() + 1]);
		}
		if (maze.cells[c.getX()][c.getY() - 1].hasBeenVisited()) {
			a.add(maze.cells[c.getX()][c.getY() - 1]);
		}
		if (maze.cells[c.getX() - 1][c.getY()].hasBeenVisited()) {
			a.add(maze.cells[c.getX() - 1][c.getY()]);
		}
		return a;
	}
}