package Logic;

public class Obstacle extends FieldObject{

	public Obstacle(Coordinate pIn, double rIn, double sIn, double aIn) {
		super(pIn, rIn, sIn, aIn );
		position=pIn;
		radius=rIn;
		spread=sIn;
		scaling=-aIn;
	
	}
	

}
