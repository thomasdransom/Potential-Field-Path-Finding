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
	public double getD(Coordinate rCoordinate, Coordinate gCoordinate)
	{
		//Finds Euclidian distance between goal and robot
	double d =	java.lang.Math.sqrt(Math.pow((gCoordinate.getX()-rCoordinate.getX()),2)+Math.pow((gCoordinate.getY()-rCoordinate.getY()), 2));
	return d;
	}
	
	//find angle by using theta = tan-1(yg-y/xg-x) use the atan2 function
	public double getTheta(Coordinate rCoordinate, Coordinate gCoordinate)
	{
		//finds the angle the robot needs to move in
		double theta = java.lang.Math.atan2((gCoordinate.getY()-rCoordinate.getY()), (gCoordinate.getX()-rCoordinate.getX()));
		return theta;
	}
	
	public Coordinate field(Robot r, Goal g)
	{
		double d,theta;
		
		d = this.getD(r.position, g.position);
		theta = this.getTheta(r.position, g.position);
		
		//if d<r then dx,dy = 0
		if(d<=g.r)
		{
			return new Coordinate(0,0);
		}
		//if r<d<=s+r then dx = a(d-r)cos(theta) and dy = a(d-r)sin(theta)
		else if(g.r<d && d<(g.s+g.r))
		{
			double dx = g.a*(d-g.r)*java.lang.Math.acos(theta);
			double dy = g.a*(d-g.r)*java.lang.Math.asin(theta);
			return new Coordinate(dx,dy);
		}
		else if(d>(g.s+g.r))
		{
			double dx = g.a*(d-g.r)*java.lang.Math.asin(theta);
			double dy = g.a*(d-g.r)*java.lang.Math.acos(theta);
			return new Coordinate(dx,dy);
		}
		return new Coordinate(0,0);
	}
	
	
	
	
	
	
	//if d>s+r then dx =a(d-r)sin(theta) and dy = a(d-r)cos(theta)
	
}
