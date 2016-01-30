import java.util.ArrayList;


public class Knight {
	private int[][] chessboard;
	private static int counter;
	private int currentRow;
	private int currentColumn;
	private int[] horizontal={2,  1,-1,-2,-2,-1,1,2};
	private int[] vertical=  {-1,-2,-2,-1, 1, 2,2,1};
	private int [][] heuristic = {{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2}};
	private int moveNumber;

public Knight(int row, int column)
{
	counter=0;
	chessboard=new int[8][8];
	for(int i = 0;i<8;i++)
	{
		for(int k = 0;k<8;k++)
			chessboard[i][k]=0;
	}
	counter++;
	currentRow=row;
	currentColumn=column;
	int morecounter=0;
	while (possibleMoves().size()!=0)
	{
		//System.out.println("NEW ITERATION");
		if(morecounter!=0)
		{	
			moveNumber=findBestMove(FindOptimalMoves(possibleMoves(), findMinHeuristicValue(possibleMoves())));//find best movenumber
			for(int c=0;c<8;c++)
			{
				if ((currentRow+vertical[c])<8&&(currentRow+vertical[c])>=0&&(currentColumn+horizontal[c])<8&&(currentColumn+horizontal[c])>=0&&c!=moveNumber)//&&chessboard[currentRow+vertical[c]][currentColumn+horizontal[c]]==0)
			{
					//System.out.println("row is "+(currentRow+vertical[c])+" column is "+(currentColumn+horizontal[c]));
				if(heuristic[currentRow+vertical[c]][currentColumn+horizontal[c]]>0&&c!=moveNumber)
						heuristic[currentRow+vertical[c]][currentColumn+horizontal[c]]--;
				
			}
		}
			currentRow=currentRow+vertical[moveNumber];//move there
		currentColumn=currentColumn+horizontal[moveNumber];//move there
		}//new column
		
		
		//printHeuristic();
		//System.out.println();
		//System.out.println("movenumber is " +moveNumber);
		//System.out.println("heuristic value is "+heuristic[currentRow][currentColumn]);
		chessboard[currentRow][currentColumn]=counter;//chessboard displays the move
		//printChessBoard();
	//	System.out.println();
		//System.out.println("current row is "+currentRow+" current column is "+ currentColumn);
		//if(heuristic[currentRow][currentColumn]>0)	
		
		heuristic[currentRow][currentColumn]--;
		//else
		//	heuristic[currentRow][currentColumn]=0;
		//System.out.println();
		//System.out.println("error might be "+heuristic[5][4]);
		//printHeuristic();
		if(possibleMoves().size()==0)
			break;
		//printHeuristic();
		//System.out.println("number of possible moves is "+possibleMoves().size());	
	//	System.out.println("number of optimal moves is "+FindOptimalMoves(possibleMoves(), findMinHeuristicValue(possibleMoves())).size());
		
		
		
			counter++;//System.out.println("row "+currentRow+"column "+ currentColumn);
	morecounter++;
	}
	//System.out.println(chessboard[currentRow+vertical[7]][currentColumn+horizontal[7]]);
//	System.out.println(currentColumn);
	
}
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
public ArrayList<Integer> possibleMoves()
{
	ArrayList<Integer> temp=new ArrayList<Integer>();
	int rowtemp=currentRow;
	int columntemp=currentColumn;
	//int minValue=8;
	//System.out.println("row being checked is "+currentRow+" column being checked is "+currentColumn);
	for(int count = 0; count<8;count++)
	{
		
		rowtemp=currentRow;
		columntemp=currentColumn;
		
		rowtemp=rowtemp+vertical[count];
		columntemp=columntemp+horizontal[count];
		 
		if(rowtemp<8&&rowtemp>=0&&columntemp<8&&columntemp>=0&&chessboard[rowtemp][columntemp]==0)//&&heuristic[rowtemp][columntemp]!=0)
		{
			//System.out.println("number in space "+chessboard[rowtemp][columntemp]);
			
			//System.out.println(count);
			
			temp.add(count); 
			
		}
		
		
		
		
	}
	//System.out.println("size of possible  moves "+temp.size());
	//after this for loop, the temp arraylist contains all the possible movenumbers.

	//my problem is that if the minimum value is one, that is taken into account and possibly the temp can be filled with only one's...
	//minValue is the minimum HEURISTIC value
	//but, the minimum heuristic value could be one or zero...
	//the minvalue is now the least heuristic value not including one and zero
	
	return temp;//it could have movenumbers that only went to one or the optimal movenumber.


}
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
public void printChessBoard()
{
	for(int a = 0;a<8;a++)
	{
		for(int b = 0;b<8;b++)
			System.out.printf("%3d",chessboard[a][b]);
	System.out.println();
	}
}
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ

public int[][] getChessboard() {
	return chessboard;
}


public void setChessboard(int[][] chessboard) {
	this.chessboard = chessboard;
}


public static int getCounter() {
	return counter;
}


public static void setCounter(int counter) {
	Knight.counter = counter;
}


public int getCurrentRow() {
	return currentRow;
}


public void setCurrentRow(int currentRow) {
	this.currentRow = currentRow;
}


public int getCurrentColumn() {
	return currentColumn;
}


public void setCurrentColumn(int currentColumn) {
	this.currentColumn = currentColumn;
}


public int[] getHorizontal() {
	return horizontal;
}


public void setHorizontal(int[] horizontal) {
	this.horizontal = horizontal;
}


public int[] getVertical() {
	return vertical;
}


public void setVertical(int[] vertical) {
	this.vertical = vertical;
}


public int[][] getHeuristic() {
	return heuristic;
}


public void setHeuristic(int[][] heuristic) {
	this.heuristic = heuristic;
}


public int getMoveNumber() {
	return moveNumber;
}


public void setMoveNumber(int moveNumber) {
	this.moveNumber = moveNumber;
}
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
public ArrayList<Integer> FindOptimalMoves(ArrayList<Integer> temp, int minValue)//temp is the possible movenumbers
{
	if(temp.size()>1)
	{
		for(int b=0;b<temp.size();b++)
	{
		int rowtemp=currentRow;
		int columntemp=currentColumn;
		
		rowtemp=rowtemp+vertical[temp.get(b)];
		columntemp=columntemp+horizontal[temp.get(b)];
		if(heuristic[rowtemp][columntemp]>minValue)//||heuristic[rowtemp][columntemp]==0)
		{
			temp.remove(b);
			b--;
		}
	}
	return temp;
	}
	else
		return temp;//for(int othercount=0;othercount<temp.size();othercount++)
	//{
	//	System.out.println("move number is "+temp.get(othercount));
	//	System.out.println("the heuristic value is "+heuristic[currentRow+vertical[temp.get(othercount)]][currentColumn+horizontal[temp.get(othercount)]]);
	//}
	//temp contains the movenumbers that either go to will make the knight go to one, or the wanted number

}
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ

public int findMinHeuristicValue(ArrayList<Integer>temp)
{
	int minValue = 8;
	for(int a = 0;a<temp.size();a++)
	{
		int rowtemp=currentRow;
		int columntemp=currentColumn;
		
		rowtemp=rowtemp+vertical[temp.get(a)];
		columntemp=columntemp+horizontal[temp.get(a)];
		if(heuristic[rowtemp][columntemp]<minValue&&heuristic[rowtemp][columntemp]>1)
		{
			minValue=heuristic [rowtemp][columntemp];
		}
	}
	return minValue;
}
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ

public int findBestMove(ArrayList <Integer> allMoves)
{
	ArrayList <Integer> heuristicvalues=new ArrayList<Integer>();
	for(int a = 0;a<allMoves.size();a++)
	{
		heuristicvalues.add(heuristic[currentRow+vertical[allMoves.get(a)]][currentColumn+horizontal[allMoves.get(a)]]);
	}
	
	
	//do this if there are other numbers besides one and zero
	for(int b = 0;b<heuristicvalues.size();b++)
		{
		if(heuristicvalues.get(b)!=1&&heuristicvalues.get(b)!=0)
			
			return allMoves.get(b);
		}	
	//do this if only ones
	if(heuristicvalues.contains(1)&&!heuristicvalues.contains(0))	
		return allMoves.get(0);
	else if(heuristicvalues.contains(1)&&heuristicvalues.contains(0))
	{
		for(int c = 0;c<allMoves.size();c++)
		{
			if(heuristicvalues.get(c)==1)
				return allMoves.get(c);
		}
	}
	//System.out.println("size of param is" +allMoves.size());
		return allMoves.get(0);
			
	
	}

//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
//נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ
public void printHeuristic()
{
	for(int a = 0;a<8;a++)
	{
		for(int b = 0;b<8;b++)
			System.out.printf("%3d",heuristic[a][b]);
	System.out.println();
	}
}
}
