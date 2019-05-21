package enums;

import lombok.Getter;

@Getter
public enum OrientationEnum {
	WEST("W","SW","NW"),
	EAST("E","NE","SE"),
	NORTH("N","NW","NE"),
	SOUTH("S","SE","SW"),
	NORTH_EAST("NE","N","E"),
	NORTH_WEST("NW","W","N"),
	SOUTH_EAST("SE","E","S"),
	SOUTH_WEST("SW","S","W");

	private final String code;
	private final String left;
	private final String right;

	// Use maps if its a large enum
	public static OrientationEnum getOrientationByCode(String code) {
		for (OrientationEnum orientation : OrientationEnum.values()) {
			if (orientation.code.equals(code)) {
				return orientation;
			}
		}
		return null;
	}
	OrientationEnum(String code , String left, String right) {
		this.code = code;
		this.left = left;
		this.right = right;
	}
}
