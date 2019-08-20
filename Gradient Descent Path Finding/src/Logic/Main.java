package Logic;


public class Main {
	
	public static void main(String args[])
	{
		Map test = new Map(50, 50);
		//System.out.println(Arrays.deepToString(test.Grid));//.replace("], ", "]\n").replaceAll("true", "X").replaceAll("false", "O"));
	
	Robot testRobo = new Robot(new Coordinate(10,10));
	Goal testGoal = new Goal(new Coordinate(20,20),1,20,0.1);
	
	Coordinate testDelta = test.field(testRobo, testGoal);
	System.out.println(testDelta.dtoString());
	
	testRobo.move(test.field(testRobo, testGoal));
	
	}
}
