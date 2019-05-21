package model;

import java.util.ArrayList;
import java.util.List;

import enums.MoveEnum;
import enums.OrientationEnum;

public class Rover {
	private final String name;
	private int x;
	private int y;
	private OrientationEnum orientation;
	private Plateau plateau;

	List<MoveEnum> moves = new ArrayList<>(0);

	public Rover(String name, int x, int y, OrientationEnum orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.name = name;
	}

	public Rover(String name, int x, int y, OrientationEnum orientation, Plateau plateau) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.plateau = plateau;
		this.name = name;
	}

	public void addMove(MoveEnum m){
		this.moves.add(m);
	}


	public void move(MoveEnum move) {
		if (MoveEnum.L.equals(move))
			moveLeft();
		else if (MoveEnum.R.equals(move))
			moveRight();
		else if (MoveEnum.M.equals(move))
			moveForward();
		else if (MoveEnum.B.equals(move))
			moveBackward();
	}

	public void moveLeft() {
		OrientationEnum currentOrienation = this.orientation;
		this.orientation =OrientationEnum.getOrientationByCode(currentOrienation.getLeft());
	}

	public void moveRight() {
		OrientationEnum currentOrienation = orientation;
		orientation = OrientationEnum.getOrientationByCode(currentOrienation.getRight());
	}

	public void moveForward() {
		int newX = x;
		int newY = y;
		switch (orientation) {
		case NORTH:
			newY++;
			break;
		case SOUTH:
			newY--;
			break;
		case WEST:
			newX--;
			break;
		case EAST:
			newX++;
			break;
		case NORTH_EAST:
			newX++;
			newY++;
			break;
		case NORTH_WEST:
			newX--;
			newY++;
			break;
		case SOUTH_EAST:
			newX++;
			newY--;
			break;
		case SOUTH_WEST:
			newX--;
			newY--;
			break;
		default:
			break;
		}
		if( plateau.canRoverMoove(name, newX, newY)){
			x = newX;
			y = newY;
		}
	}

	public void moveBackward() {
		int newX = x;
		int newY = y;
		switch (orientation) {
		case NORTH:
			newY--;
			break;
		case SOUTH:
			newY++;
			break;
		case WEST:
			newX++;
			break;
		case EAST:
			newX--;
			break;
		case NORTH_EAST:
			newX--;
			newY--;
			break;
		case NORTH_WEST:
			newX++;
			newY--;
			break;
		case SOUTH_EAST:
			newX--;
			newY++;
			break;
		case SOUTH_WEST:
			newX++;
			newY++;
			break;
		default:
			break;
		}

		if( plateau.canRoverMoove(name, newX, newY)){
			x = newX;
			y = newY;
		}
	}

	public boolean collide(int newX, int newY) {
		return (this.x == newX && this.y == newY);

	}

	public void performMoves() {
		for (MoveEnum m : moves) {
			move(m);
		}
	}

	@Override
	public String toString() {
		return this.name + " " + this.x + " " + this.y + " " + this.orientation.getCode();
	}

	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	
	public String getName() {
		return name;
	}

}
