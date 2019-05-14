package model;

import java.util.ArrayList;
import java.util.List;

import enums.MoveEnum;
import enums.OrientationEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rover {
	private int x;
	private int y;
	private OrientationEnum orientation;
	List<MoveEnum> moves = new ArrayList<>(0);
	
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
		switch (orientation) {
		case NORTH:
			y++;
			break;
		case SOUTH:
			y--;
			break;
		case WEST:
			x--;
			break;
		case EAST:
			x++;
			break;
		default:
			break;
		}
	}
	
	public void moveBackward() {
		switch (orientation) {
		case NORTH:
			y--;
			break;
		case SOUTH:
			y++;
			break;
		case WEST:
			x--;
			break;
		case EAST:
			x++;
			break;
		default:
			break;
		}
	}

	public boolean collide(Rover rover) {
		return (this.x == rover.x && this.y == rover.y);
		
	}
	
	public void performMoves() {
		for (MoveEnum m : moves) {
			move(m);
		}
	}

	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.orientation.getCode();
	}
}
