package Logic;

public class Goal extends FieldObject {
	//r = Goal Radius
	//s = Field Spread
	//a = Scalling Factor
	double r,s,a;
	Coordinate position;
	
	public Goal(Coordinate pIn, double rIn, double sIn, double aIn)
	{	
		position=pIn;
		r=rIn;
		s=sIn;
		a=aIn;
	}

}
