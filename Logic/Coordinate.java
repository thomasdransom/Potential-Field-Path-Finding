package Logic;
//Eren and Zeke were here.

public class Coordinate {
	private String name;
	private int x;// x coordinate
	private int y;// y coordinate
	private double dx,dy; // for coordinate that require a double value and for dx,dy
	
	public Coordinate(int xIn, int yIn)
	{
		name = " ";
		x = xIn;
		y = yIn;
	}
	
	public Coordinate(double dxIn, double dyIn)
	{
		name = " ";
		dx = dxIn;
		dy = dyIn;
	}
	
	public void setX(int xIn)
	{
		x = xIn;
	}
	
	public void setY(int yIn)
	{
		y = yIn;
	}
	
	public void setName(String nIn)
	{
		if(this.name.equals(" "))
		{
			name = nIn;
		}
	}
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public double getDX()
	{
		return dx;
	}
	
	public double getDY()
	{
		return dy;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return "(" + Double.toString(x) + ", " + Double.toString(y) + ")";	
	}
	
	public String dtoString()
	{
		//to string method for delta Coordinates
		return "(" + Double.toString(dx) + ", " + Double.toString(dy) + ")";
	}
	
	public double euclidian(Coordinate start, Coordinate end)
	{
		double square1 = Math.pow(end.getX()-start.getX(), 2);
		double square2 = Math.pow(end.getY()-start.getY(), 2);
		return Math.sqrt(square1+square2);
	}
	
	public Coordinate dplus(Coordinate a)
	{
		 Coordinate c = new Coordinate(this.dx + a.dx, this.dy + a.dy);
		 return c;
	}

}
