package Logic;


public class Main {
	
	public static void main(String args[])
	{
		int mapSize = 50;
		Map test = new Map(mapSize, mapSize);
		//System.out.println(Arrays.deepToString(test.Grid));//.replace("], ", "]\n").replaceAll("true", "X").replaceAll("false", "O"));
	
	Robot testRobo = new Robot(new Coordinate(10,10), mapSize, mapSize);
	Goal testGoal = new Goal(new Coordinate(40,35),1,100,0.1);
	for(int i=0; i<100; ++i)
	{
		//Coordinate testDelta = test.field(testRobo, testGoal);
		//System.out.println(testDelta.dtoString());
		testRobo.move(test.field(testRobo, testGoal));
	}
	System.out.println(testRobo.vMap.toString());
	}
}
