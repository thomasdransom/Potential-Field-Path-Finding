package Logic;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {
	
	 public static void main(String args[])
	{
		 
		// Test t = new Test();
		
//-----------------------------------------SETUP----------------------------------------------
	//Map is always square so only needs one number for size
	int mapSize = 80;
	Coordinate start = new Coordinate(10,10);
	Coordinate end = new Coordinate(20, 20);
	
	ArrayList<FieldObject> fieldObjects = new ArrayList<FieldObject>();
	
	Coordinate ob1 = new Coordinate(15,13);
	Coordinate ob2 = new Coordinate(14,13);
	Coordinate ob3 = new Coordinate(13,13);
	Coordinate ob4 = new Coordinate(12,13);
	Coordinate ob5 = new Coordinate(11,13);
	
	//TODO Create array of field objects to pass into the field() function
	
	Map testMap = new Map(mapSize, mapSize);
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
	Goal testGoal = new Goal(end,0.5,100,0.1);
	fieldObjects.add(testGoal);
	//To avoid the robot getting stuck the size of the goal should be <1
//-----------------------------------------END SET UP---------------------------------------
	
//-----------------------------------------CORE LOGIC-----------------------------------------
	//Runs loop until the robot has the same coordiantes as the goal
	
	while(testRobo.notAtGoal)
	{
		//TODO iterate through array of field objects, running field() on each, then add together their outputs, then feed into move()
		
		Coordinate total = new Coordinate(0,0);
		Iterator<FieldObject> e = fieldObjects.iterator();
		while(e.hasNext())
		{
			total = total.dplus(testMap.field(testRobo, e.next()));
		}
		
//		Coordinate temp1 = testMap.field(testRobo, testGoal);
//		
//		Coordinate temp2 = testMap.field(testRobo, obstacle1);
//		Coordinate temp3 = testMap.field(testRobo, obstacle2);
//		Coordinate temp4 = testMap.field(testRobo, obstacle3);
//		Coordinate temp5 = testMap.field(testRobo, obstacle4);
//		Coordinate temp6 = testMap.field(testRobo, obstacle5);
//		
//		temp1 = temp1.dplus(temp2);
//		temp1 = temp1.dplus(temp3);
//		temp1 = temp1.dplus(temp4);
//		temp1 = temp1.dplus(temp5);
//		temp1 = temp1.dplus(temp6);
		
		testRobo.move(total);
		if(testRobo.eQ(testGoal))
		{
			testRobo.arrived();
		}
	}
	
//-----------------------------------------END CORE LOGIC-------------------------------------
	System.out.println(testRobo.vMap.toString());
	
	}
}

