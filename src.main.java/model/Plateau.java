package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.OutOfBoundException;
import exception.RockCollisionException;
import exception.RoverCollisionException;


public class Plateau {
	private final int width;

	private final int heigh;

	private final List<Rover> rovers = new ArrayList<>(0);
	private List<Rock> rocks = new ArrayList<>(0);
	
	public Plateau(int width, int heigh) {
		super();
		this.width = width;
		this.heigh = heigh;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeigh() {
		return heigh;
	}

	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	public void addRock(Rock rock) {
		rocks.add(rock);
	}

	public List<Rover> getRovers() {
		final List<Rover> rovers = this.rovers;
		return rovers;
	}
	
	public boolean roverIsInBound(String name, int x, int y) throws OutOfBoundException{
		boolean inBound = (0 <= x && width >= x && 0 <= y && heigh >= y);
		if(!inBound)
			throw new OutOfBoundException(name , x, y);
		return true;
	}
	
	public boolean rockCollision(String name, int x, int y) throws RockCollisionException{
		boolean collision = false;
		for (Iterator<Rock> iterator = rocks.iterator(); iterator.hasNext() && !collision;) {
			if (iterator.next().collide(x, y))
				collision = true;
		}
		if(collision)
			throw new RockCollisionException(name , x, y);
		return false;
	}
	
	public boolean roverCollision(String name, int x, int y) throws RoverCollisionException{
		boolean collision = false;
		String roverCollisionName = null;
		for (Iterator<Rover> iterator = rovers.iterator(); iterator.hasNext() && collision;) {
			Rover rover = iterator.next();
			if (rover.collide(x, y)) {
				collision = true;
				roverCollisionName = rover.getName();
			}
		}
		if(collision)
			throw new RoverCollisionException(name , roverCollisionName, x, y);
		return false;
	}
	
	public boolean canRoverMoove(String name, int x, int y) {
		try {
			return roverIsInBound(name, x, y) && !rockCollision(name, x, y) && !roverCollision(name, x, y);
		}catch(RockCollisionException ex) {
			System.out.println(ex.getMessage());
		} catch (RoverCollisionException ex) {
			System.out.println(ex.getMessage());
		} catch (OutOfBoundException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	
}
