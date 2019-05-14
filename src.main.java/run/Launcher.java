package run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
			while(scan.hasNext()) {
				Rover rover = new Rover();
				rover.setX(scan.nextInt());
				rover.setY(scan.nextInt());
				rover.setOrientation(OrientationEnum.getOrientationByCode(scan.next()));
				char[] moves = scan.next().toCharArray();
				for (Character c : moves) {
					rover.addMove(MoveEnum.valueOf(""+c));
				}
				plateau.add(rover);
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
		
		initMarsRover(args[0]);
		moveRovers();
		showRoversPosition();
	}
}
