package Logic;
import java.util.Iterator;

public class Main {
	
	 @SuppressWarnings("unused")
	public static void main(String args[])
	{
		 int stepCounter =0;
		
//-----------------------------------------SETUP----------------------------------------------
	//Map is always square so only needs one number for size
	int mapSize = 80;
	Map testMap = new Map(mapSize, mapSize);
	
	Coordinate start = testMap.Grid[10][1];
	start.setName("S");
	Goal testGoal = new Goal(25,35,0.5,100,0.1,testMap);
	
	//(Starting position, mapsize x, mapsize y)
	Robot testRobo = new Robot(start, mapSize, mapSize);
	
	//(X, Y, radius, spread, scaling, map)
	
	Obstacle obstacle1 = new Obstacle(11, 13, 0.5, 3, 0.005, testMap);
	Obstacle obstacle2 = new Obstacle(11, 14, 0.5, 3, 0.005, testMap);
	Obstacle obstacle3 = new Obstacle(11, 15, 0.5, 3, 0.005, testMap);
	Obstacle obstacle4 = new Obstacle(11, 16, 0.5, 3, 0.005, testMap);
	Obstacle obstacle5 = new Obstacle(11, 17, 0.5, 5, 0.005, testMap);
	Obstacle obstacle6 = new Obstacle(11, 18, 0.5, 5, 0.005, testMap);
	Obstacle obstacle7 = new Obstacle(11, 19, 0.5, 3, 0.005, testMap);
	Obstacle obstacle8 = new Obstacle(11, 20, 0.5, 3, 0.005, testMap);
	Obstacle obstacle9 = new Obstacle(11, 21, 0.5, 3, 0.005, testMap);
	Obstacle obstacle10 = new Obstacle(11, 22, 0.5, 3, 0.005, testMap);
	Obstacle obstacle11 = new Obstacle(11, 23, 0.5, 3, 0.005, testMap);
		
		
	
	//To avoid the robot getting stuck the size of the goal should be <1
//-----------------------------------------END SET UP---------------------------------------
	
//-----------------------------------------CORE LOGIC-----------------------------------------
	//Runs loop until the robot has the same coordiantes as the goal
	
	
	
	while(testRobo.notAtGoal)
	{		
		Coordinate total = new Coordinate(0,0);
		Iterator<FieldObject> e = testMap.fieldObjects.iterator();
		while(e.hasNext())
		{
			
			total = total.dplus(testMap.field(testRobo, e.next()));
		}
		

		testRobo.move(total, testMap);
		if(testRobo.eQ(testGoal))
		{
			testRobo.arrived();
		}
		if(stepCounter> 60) {
			testRobo.arrived();
		}
		stepCounter++;
	}
	
//-----------------------------------------END CORE LOGIC-------------------------------------
	System.out.println(testMap.toString());
	
	}
}

