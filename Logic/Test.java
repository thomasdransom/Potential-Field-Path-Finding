package Logic;

public class Test { 
	
	
	public Test() {
		double theta, distance, x, y, dx, dy;
		
		theta = 1.57;
		distance = 1.0;
		
		dx = distance*java.lang.Math.cos(theta);
		dy = distance*java.lang.Math.sin(theta);
		
		System.out.println("dx = " + dx);
		System.out.println("dy = " + dy);
		
		System.exit(0);
		
		
	}
	
	
	/*
	 * When dx or dy values are below 0.5 they round down to 0. 
	 * This means when the robot approaches the target it stops moving towrds this.
	 * Fix by PID?
	 * Fix by increasing scaling factor if robot doesnt move?
	 * 
	 * 
	 */

}
