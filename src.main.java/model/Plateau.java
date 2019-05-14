package model;

import java.util.ArrayList;
import java.util.List;


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

	public void add(Rover rover) {
		rovers.add(rover);
	}

	public List<Rover> getRovers() {
		final List<Rover> rovers = this.rovers;
		return rovers;
	}

	
	
}
