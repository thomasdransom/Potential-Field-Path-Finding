package Logic;

public class Obstacle extends FieldObject{

	public Obstacle(int xIn, int yIn, double rIn, double sIn, double aIn, Map mIn) {
		super(xIn, yIn, rIn, sIn, aIn, mIn );
		
		scaling=-aIn;
		this.position.setName("O");
		
		
	}
	

}
