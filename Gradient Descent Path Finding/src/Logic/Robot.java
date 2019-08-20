package Logic;

public class Robot {
	
	Coordinate position;
	VisualMap vMap;
	
	public Robot(Coordinate start, int x, int y) 
	{
		position=start;
		vMap = new VisualMap(x,y);
		vMap.addLoc(start.getX(), start.getY());
	}
	
	public void move(double moveX, double moveY)
			{
		
		//TODO clean up this function (better variable names)
				double newX = this.position.getX()+moveX;
				//creates a double equal to the new position of the robot after it moves
				int nX = (int) java.lang.Math.ceil(newX);
				//rounds the variable for use in integer co-ordinates
				this.position.setX(nX);
				//sets the new position of the robot
				
				//repeats the above for Y variable
				double newY = this.position.getY()+moveY;
				int nY = (int) java.lang.Math.ceil(newY);
				this.position.setY(nY);
			}
	//Function for moving robot with a coordinate object
	public void move(Coordinate move)
	{

//TODO clean up this function (better variable names)
		
		
		double newX = this.position.getX()+move.getDX();
		//calculates new position using old position and movement
		int nX = (int) java.lang.Math.ceil(newX);
		// rounds value to an integer
		this.position.setX(nX);
		//sets new position
		System.out.print("X: " + this.position.getX() + " ");
		
		
		//repeats about for Y variable
		double newY = this.position.getY()+move.getDY();
		int nY = (int) java.lang.Math.ceil(newY);
		this.position.setY(nY);
		System.out.println("Y: " + this.position.getY());
		vMap.addLoc(this.position.getX(), this.position.getY());
		
	}


}
