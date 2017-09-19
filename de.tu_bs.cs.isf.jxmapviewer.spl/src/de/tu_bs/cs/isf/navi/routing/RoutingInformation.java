package de.tu_bs.cs.isf.navi.routing;

import java.util.ArrayList;
import java.util.List;

public class RoutingInformation {
	
	private List<RoutingStepInformation> steps;
	public static RoutingInformation currentRoute;
	private List<double[]> polygonPoints;
	
	public RoutingInformation() {
		steps = new ArrayList<RoutingStepInformation>();
		polygonPoints = new ArrayList<double[]>();
	}
	
	public void addStep(RoutingStepInformation o) {
		steps.add(o);
	}
	
	public List<RoutingStepInformation> getRoutingInformation() {
		return steps;
	}

	public String[] getRouteInstructions() {
		String[] output = new String[steps.size()];
		for(int i=0; i<output.length; i++) {
			output[i] = steps.get(i).getInstruction();
		}
		
		return output;
	}
	
	public void addPolygonPoint(double latitude, double longitude) {
		double[] add = {latitude, longitude};
		polygonPoints.add(add);
	}
	
	public List<double[]> getPolygonPoints() {
		return polygonPoints;
	}
 }
