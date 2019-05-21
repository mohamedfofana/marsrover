package exception;

public class RoverCollisionException extends Exception {
	String roverName1;
	String roverName2;
	String targetX;
	String targetY;
	public RoverCollisionException(String roverName1, String roverName2, int targetX, int targetY) {
		super(String.format("RockCollisionException : %s cannot move to position (%s,%s) due to colission with %s", roverName1, targetX, targetY, roverName2));
	}
}
