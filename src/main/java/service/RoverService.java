package main.java.service;

import java.util.List;

import main.java.enums.MoveEnum;
import main.java.model.Rover;

public interface RoverService {
	public void move(Rover rover, MoveEnum move);
	public void moveLeft(Rover rover);
	public void moveRight(Rover rover);
	public void moveForward(Rover rover);
	public void showRoversPosition(List<Rover> rovers);
}
