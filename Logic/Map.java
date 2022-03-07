package Logic;

import java.lang.Math;

public class Map {
	Coordinate Grid[][];
	int xSize;
	int ySize;
	
	Map(int x, int y){
		Grid = new Coordinate[x][y];
		xSize=x;
		ySize=y;
		
		//populates the 2d matrix with coordinate object with the correct x and y values
		for(int i=0; i<xSize; i++)
		{
			for(int j=0; j<ySize; j++)
			{
				Grid[i][j] = new Coordinate(i,j);
			}
		}
	}
	
	
	
	//x,y is current robot position
	//xg,yg is the position of the goal
	//dx,dy is output vector for the robot
	//r is the radius of the goal
	//s is the spread of the field
	//a is scaling factor
	//find distance to goal by using sqrt((xg-x)^2+(yg-y)^2)
	public double getD(Coordinate coordinateA, Coordinate coordinateB)
	{
		//Finds Euclidian distance between field object and robot
	double d =	java.lang.Math.sqrt(Math.pow((coordinateB.getX()-coordinateA.getX()),2)+Math.pow((coordinateB.getY()-coordinateA.getY()), 2));
	return d;
	}
	
	//find angle by using theta = tan-1(yg-y/xg-x) use the atan2 function
	public double getTheta(Coordinate coordinateA, Coordinate coordianteB)
	{
		//finds the angle the robot needs to move in
		double theta = java.lang.Math.atan2((coordianteB.getY()-coordinateA.getY()), (coordianteB.getX()-coordinateA.getX()));
		return theta;
	}
	
	public Coordinate field(Robot robot, FieldObject target)
	{
		//d is the distance between 2 field objects
		// theta is the angle 
		double distance,theta,dx,dy;
		
		distance = this.getD(robot.position, target.position);
		theta = this.getTheta(robot.position, target.position);
		//theta = 0;
		//System.out.println(theta);
		/*if (theta > 1 || theta < -1)
		{
			System.exit(0);
		}*/
		
		//if d<r then dx,dy = 0
		//If the distance between the robot and the goal is less that the goals radius, then the robot doesnt move.
		if(distance < target.radius)
		{
			return new Coordinate(0,0);
		}
		
		
		if(target.scaling > 0)
		{
				
			
			
			//if r<d<=s+r then dx = a(d-r)cos(theta) and dy = a(d-r)sin(theta)
			if(target.radius < distance && distance < (target.spread+target.radius) && theta >= 0)
			{
				//System.out.println(g.a + "," + d + "," + g.r + ", t: " + theta + "," + java.lang.Math.acos(theta));
				dx = target.scaling*(distance-target.radius)*java.lang.Math.cos(theta)*robot.integrator;
				dy = target.scaling*(distance-target.radius)*java.lang.Math.sin(theta)*robot.integrator;
				return new Coordinate(dx,dy);
			}
			else if(target.radius < distance && distance < (target.spread+target.radius) && theta<0)
			{
				dx = target.scaling*(distance-target.radius)*java.lang.Math.sin(theta)*robot.integrator;
				dy = target.scaling*(distance-target.radius)*java.lang.Math.cos(theta)*robot.integrator;
				return new Coordinate(dx,dy);
			}
			//if r<d<=s+r then dx = a(d-r)cos(theta) and dy = a(d-r)sin(theta)
		}
		else
		{
			if(target.radius < distance && distance < (target.spread+target.radius) && theta >= 0)
			{
				//System.out.println(g.a + "," + d + "," + g.r + ", t: " + theta + "," + java.lang.Math.acos(theta));
				dx = (target.scaling*java.lang.Math.cos(theta)*robot.integrator)/Math.pow(distance, 2);
				dy = (target.scaling*java.lang.Math.sin(theta)*robot.integrator)/Math.pow(distance, 2);
				return new Coordinate(dx,dy);
			}
			else if(target.radius < distance && distance < (target.spread+target.radius) && theta<0)
			{
				dx = (target.scaling*java.lang.Math.sin(theta)*robot.integrator)/Math.pow(distance, 2);
				dy = (target.scaling*java.lang.Math.cos(theta)*robot.integrator)/Math.pow(distance, 2);
				return new Coordinate(dx,dy);
			}
		}
		return new Coordinate(0,0);
		
	}
	 
	
	
	
	
	
																							
}
