package Logic;

import java.util.Arrays;

public class VisualMap {
	boolean Grid[][];
	int xSize;
	int ySize;
	
	public VisualMap(int x, int y){
		Grid = new boolean[x][y];
		xSize=x;
		ySize=y;
	}
	
	public void addLoc(int x, int y){
		Grid[y][x] = true;
		//System.out.println("added: " + x + "," + y);
	}
	public void removeLoc(int x, int y){
		Grid[y][x] = false;
	}
	
	public String toString()
	{
		return Arrays.deepToString(this.Grid).replace("], ", "]\n").replaceAll("true", "X").replaceAll("false", " ");
	}
}
