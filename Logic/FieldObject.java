package Logic; 
public class FieldObject 
{
	
	//r = Goal Radius
	//s = Field Spread
	//a = Scaling Factor
	double radius,spread,scaling;
	Coordinate position;
	
	public FieldObject(int xIn, int yIn, double rIn, double sIn, double aIn, Map mIn)
	{	
	
		radius=rIn;
		spread=sIn;
		scaling=aIn;
		
		position = mIn.Grid[yIn][xIn];
		mIn.fieldObjects.add(this);
	}
	//Class exists for future tidying and streamlining of the field process after the core behaviour has been achieved
}
