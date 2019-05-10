package main.java.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.enums.MoveEnum;
import main.java.enums.OrientationEnum;
import main.java.model.Plateau;
import main.java.model.Rover;
import main.java.service.RoverService;
import main.java.service.impl.RoverServiceImpl;

public class Launcher {
	static private List<Rover> rovers;
	static private Plateau plateau;
	static private RoverService roverService;

	private static void initMarsRover(String filepath) {
		try(FileInputStream in = new FileInputStream(filepath); Scanner scan = new Scanner(in);){
			rovers = new ArrayList<Rover>();
			plateau = new Plateau();
			plateau.setWidth(scan.nextInt());
			plateau.setHeigh(scan.nextInt());

			roverService = new RoverServiceImpl(plateau);

			while(scan.hasNext()) {
				Rover rover = new Rover();
				rover.setX(scan.nextInt());
				rover.setY(scan.nextInt());
				//				rover.setOrientation(OrientationEnum.getOrientationByCode(scan.next()));
				rover.setOrientation(OrientationEnum.getOrientationByCode(scan.next()));
				char[] moves = scan.next().toCharArray();
				for (Character c : moves) {
					rover.addMove(MoveEnum.valueOf(""+c));
				}
				rovers.add(rover);
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist/");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to extract informations in the file.");
			e.printStackTrace();
		}
	}

	public static void moveRovers() {
		for (Rover rover : rovers) {
			for (MoveEnum move : rover.getMoves()) {
				roverService.move(rover, move);
			}
		}
	}

	public static void showRoversPosition() {
		roverService.showRoversPosition(rovers);
	}

	public static void main(String[] args) {
		if (args == null) {
			System.out.println("You must enter an input file.");
			return;
		}
		initMarsRover(args[0]);
		moveRovers();
		showRoversPosition();
	}
}
