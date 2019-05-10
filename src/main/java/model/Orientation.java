package main.java.model;

import lombok.Getter;
import lombok.Setter;
import main.java.enums.OrientationEnum;

@Getter
@Setter
public class Orientation {
	private OrientationEnum orientation;
	private Orientation left;
	private Orientation right;
}
