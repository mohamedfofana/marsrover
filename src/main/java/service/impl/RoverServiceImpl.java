package main.java.service.impl;

import java.util.List;

import main.java.enums.MoveEnum;
import main.java.enums.OrientationEnum;
import main.java.model.Plateau;
import main.java.model.Rover;
import main.java.service.RoverService;

public class RoverServiceImpl implements RoverService {
	Plateau plateau;
	public RoverServiceImpl(Plateau plateau) {
		this.plateau = plateau;
	}

	@Override
	public void move(Rover rover, MoveEnum move) {
		if (MoveEnum.L.equals(move))
			moveLeft(rover);
		else if (MoveEnum.R.equals(move))
			moveRight(rover);
		else if (MoveEnum.M.equals(move))
			moveForward(rover);
	}

	@Override
	public void moveLeft(Rover rover) {
		OrientationEnum currentOrienation = rover.getOrientation();
		rover.setOrientation(OrientationEnum.getOrientationByCode(currentOrienation.getLeft()));
	}

	@Override
	public void moveRight(Rover rover) {
		OrientationEnum currentOrienation = rover.getOrientation();
		rover.setOrientation(OrientationEnum.getOrientationByCode(currentOrienation.getRight()));
	}

	@Override
	public void moveForward(Rover rover) {
		if (OrientationEnum.NORTH.equals(rover.getOrientation()))
			rover.setY(rover.getY()+1);
		if (OrientationEnum.SOUTH.equals(rover.getOrientation()))
			rover.setY(rover.getY()-1);
		if (OrientationEnum.WEST.equals(rover.getOrientation()))
			rover.setX(rover.getX()+1);
		if (OrientationEnum.EAST.equals(rover.getOrientation()))
			rover.setX(rover.getX()-1);
	}

	@Override
	public void showRoversPosition(List<Rover> rovers) {
		for (Rover rover : rovers) {
			System.out.print(rover.toString() + " ");
		}
	}



}
