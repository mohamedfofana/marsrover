package main.java.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import main.java.enums.MoveEnum;
import main.java.enums.OrientationEnum;

@Getter
@Setter
public class Rover {
	private int x;
	private int y;
	private OrientationEnum orientation;
	List<MoveEnum> moves;
	
	public Rover() {
		moves = new ArrayList<MoveEnum>();
	}
	
	public void addMove(MoveEnum m){
		this.moves.add(m);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.x + " " + this.y + " " + this.orientation.getCode();
	}
}
