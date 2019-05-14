package service.impl;

import model.Plateau;
import model.Rover;
import service.RoverService;

public class RoverServiceImpl implements RoverService {
	private Plateau plateau;

	public RoverServiceImpl() {
	}
	public RoverServiceImpl(Plateau plateau) {
		this.plateau = plateau;
	}

	@Override
	public void showRoversPosition() {
		for (Rover rover : plateau.getRovers()) {
			System.out.print(rover.toString() + " ");
		}
	}
	@Override
	public void moveRovers() {
		for (Rover rover: plateau.getRovers()) {
			rover.performMoves();
		}
		
	}
}
