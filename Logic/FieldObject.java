package Logic; 
public class FieldObject 
{
	
	//r = Goal Radius
	//s = Field Spread
	//a = Scaling Factor
	double radius,spread,scaling;
	Coordinate position;
	
	public FieldObject(Coordinate pIn, double rIn, double sIn, double aIn)
	{	
		position=pIn;
		radius=rIn;
		spread=sIn;
		scaling=aIn;
	}
	//Class exists for future tidying and streamlining of the field process after the core behaviour has been achieved
}
