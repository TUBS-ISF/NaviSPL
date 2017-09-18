package de.tu_bs.cs.isf.navi.routing;

public class RoutingStepInformation {
	private Number duration;
	private Number distance;
	private String instruction;
	private String name;
	private Number type;
	private Number[] wayPoint = new Number[2];
	
	public RoutingStepInformation(Number duration, Number distance, String instruction, String name, Number type, Number wayPointX, Number wayPointY) {
		this.setDuration(duration);
		this.setDistance(distance);
		this.setInstruction(instruction);
		this.setName(name);
		this.setType(type);
		this.wayPoint[0] = wayPointX;
		this.wayPoint[1] = wayPointY;
	}

	public Number getDuration() {
		return duration;
	}

	public void setDuration(Number duration) {
		this.duration = duration;
	}

	public Number getDistance() {
		return distance;
	}

	public void setDistance(Number distance) {
		this.distance = distance;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getType() {
		return type;
	}

	public void setType(Number type) {
		this.type = type;
	}
}
