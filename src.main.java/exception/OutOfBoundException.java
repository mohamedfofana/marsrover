package exception;

public class OutOfBoundException extends Exception{
	String roverName;
	String targetX;
	String targetY;
	public OutOfBoundException(String roverName, int targetX, int targetY) {
		super(String.format("OutOfBoundException : %s cannot move to position (%s,%s)", roverName, targetX, targetY));
	}
}
