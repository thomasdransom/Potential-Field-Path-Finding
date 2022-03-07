package Logic;

public class Robot {
	
	Coordinate position;
	VisualMap vMap;
	boolean notAtGoal;
	double integrator;
	
	
	public Robot(Coordinate start, int x, int y) 
	{
		position=start;
		vMap = new VisualMap(x,y);
		vMap.addLoc(start.getX(), start.getY());
		notAtGoal = true;
		integrator = 1.0;
	}
	
	public void arrived() {
		notAtGoal = false;
	}
	
	public boolean eQ(FieldObject o)
	{
		if (this.position.getX() == o.position.getX() && this.position.getY() == o.position.getY())
		{
			return true;
		}
		return false;
		
	}
	
	public void move(double moveX, double moveY)
			{
				if(moveX <= 0.5 && moveX >= -0.5 && moveY <= 0.5 && moveY >= -0.5)
				{
					this.integrator = this.integrator + 2;
				}
				else
				{
					this.integrator = 1;
				}
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
		
		if(move.getDX() <= 0.5 && move.getDX() >= -0.5 && move.getDY() <= 0.5 && move.getDY() >= -0.5)
		{
			this.integrator = this.integrator + 2;
		}
		else
		{
			this.integrator = 1;
		}
		
		
		double newX = this.position.getX()+move.getDX();
		//calculates new position using old position and movement
		int nX = (int) java.lang.Math.round(newX);
		// rounds value to an integer
		this.position.setX(nX);
		//sets new position
		System.out.print("X: " + this.position.getX() + " ");
		
		
		//repeats about for Y variable
		double newY = this.position.getY()+move.getDY();
		int nY = (int) java.lang.Math.round(newY);
		this.position.setY(nY);
		System.out.println("Y: " + this.position.getY());
		vMap.addLoc(this.position.getX(), this.position.getY());
		
	}


}
