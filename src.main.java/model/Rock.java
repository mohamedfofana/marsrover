package model;

public class Rock {
	private final int x;
	private final int y;
	
	public Rock(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean collide(int newX, int newY) {
		return (this.x == newX && this.y == newY);

	}
}
