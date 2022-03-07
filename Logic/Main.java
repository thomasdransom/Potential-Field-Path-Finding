package Logic;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {
	
	 public static void main(String args[])
	{
		 
		
//-----------------------------------------SETUP----------------------------------------------
	//Map is always square so only needs one number for size
	int mapSize = 80;
	Map testMap = new Map(mapSize, mapSize);
	
	
	Coordinate start = testMap.Grid[10][10];
	start.setName("S");
	Coordinate goal = testMap.Grid[20][20];
	goal.setName("G");
	
	ArrayList<FieldObject> fieldObjects = new ArrayList<FieldObject>();
	
	Coordinate ob1 = testMap.Grid[15][13];
	Coordinate ob2 = testMap.Grid[14][13];
	Coordinate ob3 = testMap.Grid[13][13];
	Coordinate ob4 = testMap.Grid[12][13];
	Coordinate ob5 = testMap.Grid[11][13];
	ob1.setName("O");
	ob2.setName("O");
	ob3.setName("O");
	ob4.setName("O");
	ob5.setName("O");
	
	
	
	//(Starting position, mapsize x, mapsize y)
	Robot testRobo = new Robot(start, mapSize, mapSize);
	//TODO make the visual map part of the regular map, not part of the robot
	
	Obstacle obstacle1 = new Obstacle(ob1, 0.5, 5, 0.2);
	Obstacle obstacle2 = new Obstacle(ob2, 0.5, 5, 0.2);
	Obstacle obstacle3 = new Obstacle(ob3, 0.5, 5, 0.2);
	Obstacle obstacle4 = new Obstacle(ob4, 0.5, 5, 0.2);
	Obstacle obstacle5 = new Obstacle(ob5, 0.5, 5, 0.2);
	fieldObjects.add(obstacle1);
	fieldObjects.add(obstacle2);
	fieldObjects.add(obstacle3);
	fieldObjects.add(obstacle4);
	fieldObjects.add(obstacle5);
	
	
	// ((Starting X, Starting Y), Size of Goal, Field Spread, Scaling Factor) 
	Goal testGoal = new Goal(goal,0.5,100,0.1);
	fieldObjects.add(testGoal);
	//To avoid the robot getting stuck the size of the goal should be <1
//-----------------------------------------END SET UP---------------------------------------
	
//-----------------------------------------CORE LOGIC-----------------------------------------
	//Runs loop until the robot has the same coordiantes as the goal
	
	System.out.println(testMap.Grid[1][10].toString());
	
	while(testRobo.notAtGoal)
	{
		//TODO iterate through array of field objects, running field() on each, then add together their outputs, then feed into move()
		
		Coordinate total = new Coordinate(0,0);
		Iterator<FieldObject> e = fieldObjects.iterator();
		while(e.hasNext())
		{
			total = total.dplus(testMap.field(testRobo, e.next()));
		}
		

		testRobo.move(total, testMap);
		if(testRobo.eQ(testGoal))
		{
			testRobo.arrived();
		}
	}
	
//-----------------------------------------END CORE LOGIC-------------------------------------
	System.out.println(testMap.toString());
	
	}
}

