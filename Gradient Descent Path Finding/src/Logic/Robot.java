package Logic;

public class Robot {
	
	Coordinate position;
	
	public Robot(Coordinate start) 
	{
		position=start;
	}
	
	public void move(double moveX, double moveY)
			{
		
		//TODO clean up this function (better variable names)
				double newX = this.position.getX()+moveX;
				int nX = (int) java.lang.Math.round(newX);
				this.position.setX(nX);
				
				double newY = this.position.getY()+moveY;
				int nY = (int) java.lang.Math.round(newY);
				this.position.setY(nY);
			}
	
	public void move(Coordinate move)
	{

//TODO clean up this function (better variable names)
		double newX = this.position.getX()+move.getX();
		int nX = (int) java.lang.Math.round(newX);
		this.position.setX(nX);
		System.out.print(this.position.getX()+ "\n");
		
		double newY = this.position.getY()+move.getY();
		int nY = (int) java.lang.Math.round(newY);
		this.position.setY(nY);
		System.out.println(this.position.getY());
	}


}
