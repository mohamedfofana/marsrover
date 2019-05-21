package exception;

public class RockCollisionException extends Exception {
	String roverName;
	String targetX;
	String targetY;
	public RockCollisionException(String roverName, int targetX, int targetY) {
		super(String.format("RockCollisionException : %s cannot move to position (%s,%s)", roverName, targetX, targetY));
	}
}
