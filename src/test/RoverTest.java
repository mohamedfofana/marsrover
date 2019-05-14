
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import enums.OrientationEnum;
import model.Plateau;
import model.Rover;
import service.impl.RoverServiceImpl;

public class RoverTest {
	RoverServiceImpl roverService;
	Rover rover;
	Plateau plateau;
	
	@Before
	public void initRovers() {
		roverService = new RoverServiceImpl();
		rover = new Rover();
		rover.setX(3);
		rover.setY(3);
		rover.setOrientation(OrientationEnum.NORTH);
	}
	
	@Test
	public void moveForward_from_north_3_3_should_be_3_4() {
		// GIVEN
		Rover rover = rover(3, 3, OrientationEnum.NORTH);
		int expectedY = 4;
		int expectedX = 3;
		
		// WHEN
		rover.moveForward();
		
		// THEN
		assertEquals(expectedY, rover.getY());
		assertEquals(expectedX, rover.getX());
	}

	private Rover rover(int x, int y, OrientationEnum orientation) {
		Rover rover = new Rover();
		rover.setX(x);
		rover.setY(y);
		rover.setOrientation(orientation);
		return rover;
	}
}
