import java.awt.Graphics2D;
import java.util.*;
public class KnightsTour
{
	public static void main (String [] args)
	{
		
		Scanner console=new Scanner (System.in);
		
		//String input2=null;
		
		char input='y';
		
	
		while(input=='y')
		{
			console=new Scanner (System.in);
			System.out.println("All possible tours, or one tour? all/one");
			String input2=null;
			input2=console.next();
			
			if(input=='y'&&input2.charAt(0)=='o')
			{
			System.out.println("Input the row? ");
			int row=console.nextInt();
			System.out.println("Input the column ");
			int column=console.nextInt();
			Knight imalan=new Knight(row,column);
			
			imalan.printChessBoard();
			System.out.println("The knight made "+(imalan.getCounter())+" moves");
			}
			else if (input=='y'&&input2.charAt(0)=='a')
			{
				for(int a = 0;a<8;a++)
				{
					for(int b = 0;b<8;b++)
					{
						Knight temp=new Knight(a,b);
						temp.printChessBoard();
						System.out.println();
						System.out.println("The knight made "+(temp.getCounter())+" moves");
						System.out.println();
					}
				}
			}
				System.out.println("again? y/n");
			input=console.next().charAt(0);
		}
		
	}
}