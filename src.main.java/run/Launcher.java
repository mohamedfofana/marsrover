package run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import enums.MoveEnum;
import enums.OrientationEnum;
import model.Plateau;
import model.Rock;
import model.Rover;
import service.impl.RoverServiceImpl;

public class Launcher {
	static private RoverServiceImpl roverService;

	private static void initMarsRover(String filepath) {
		try(FileInputStream in = new FileInputStream(filepath); Scanner scan = new Scanner(in);){
			Plateau plateau = new Plateau(scan.nextInt(), scan.nextInt());
			roverService = new RoverServiceImpl(plateau);
			int nbRocks = scan.nextInt();
			for (int i = 0; i < nbRocks; i++) {
				Rock rock = new Rock(scan.nextInt(), scan.nextInt());
				plateau.addRock(rock);
			}
			while(scan.hasNext()) {
				Rover rover = new Rover(scan.next(), scan.nextInt(), scan.nextInt(), OrientationEnum.getOrientationByCode(scan.next()), plateau);
				char[] moves = scan.next().toCharArray();
				for (Character c : moves) {
					rover.addMove(MoveEnum.valueOf(""+c));
				}
				plateau.addRover(rover);
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
		roverService.moveRovers();
	}

	public static void showRoversPosition() {
		roverService.showRoversPosition();
	}

	public static void main(String[] args) {
		if (args == null) {
			System.out.println("You must enter an input file.");
			return;
		}
		
//		initMarsRover(args[0]);
		initMarsRover("/Users/mfofana/Meritis/input_rocks_simple.txt");
		moveRovers();
		showRoversPosition();
	}
}
