package tic_toe1;
import java.util.Scanner;
class TicGame
{
public String[][] board;
public String currentPlayerMark;

public TicGame()
{
  board = new String[3][3];
  currentPlayerMark = "o";
  initializeBoard();

}

public String getCurrentPlayerMark()
{
  return currentPlayerMark;
}

public void initializeBoard()
{
  for(int i=0;i<3;i++)
    {
      for(int j=0;j<3;j++)
            {
                board[i][j]="-";
            }
    }
}
public void printBoard()
{
System.out.println("************");
for(int i=0;i<3;i++)
{
  System.out.print("|");
  for(int j=0;j<3;j++)
    {
      System.out.print(board[i][j]+"|");
    }
    System.out.println();
}
System.out.println("************");
}

public boolean isBoardFull()
{
boolean isfull=true;
for(int i=0;i<3;i++)
{
  for(int j=0;j<3;j++)
  {
    if(board[i][j].equals("-"))
    isfull=false;
  }
}
return isfull;
}

public boolean checkall(String a1, String a2, String a3)
{
	return ((!a1.equals("-")) && (a1.equals(a2)) && (a2.equals(a3)));
}
public boolean checkRowsForWin()
{
  for (int i = 0; i < 3; i++) {
      if (checkall(board[i][0], board[i][1], board[i][2]) == true) {
          return true;
      }
  }
  return false;
}
public boolean checkColumnsForWin()
{
  for (int i = 0; i < 3; i++) {
      if (checkall(board[0][i], board[1][i], board[2][i]) == true) {
          return true;
      }
  }
  return false;
}
public boolean checkDiagonalsForWin()
{
    return ((checkall(board[0][0], board[1][1], board[2][2]) == true) || (checkall(board[0][2], board[1][1], board[2][0]) == true));
}
public boolean MarkThePlace(int row, int col) {

    if ((row >= 0) && (row < 3)) {
        if ((col >= 0) && (col < 3)) {
            if (board[row][col].equals("-")) {
                board[row][col] = currentPlayerMark;
                return true;  }}
    }

    return false;
}
public boolean checkWin() {
    return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
}
public void changePlayer() {
    if (currentPlayerMark.equals("x")) {
        currentPlayerMark = "o";
    }
    else {
        currentPlayerMark = "x";
    }
}
}
class operation
{
  public int row;
  public int column;
  
}
class new1
{
	String player = "x", player2 = "o";
public boolean checkingmovesleft(String board[][])
{
	for (int i = 0; i<3; i++)
		for (int j = 0; j<3; j++)
			if (board[i][j].equals("-"))
				return true;
	return false;
}
public int GivingPoints(String board1[][])
{
	for (int row = 0; row<3; row++)
	{
		if (board1[row][0].equals(board1[row][1]) &&
			board1[row][1].equals(board1[row][2]))
		{ 
			if (board1[row][0].equals(player))
				return +1;
			else if (board1[row][0].equals(player2))
				return -1;
		}
	}
	for (int col = 0; col<3; col++)
	{
		if (board1[0][col].equals(board1[1][col]) &&
			board1[1][col].equals(board1[2][col]))
		{
			if (board1[0][col].equals(player))
				return +1;

			else if (board1[0][col].equals(player2))
				return -1;
		}
	}

	if (board1[0][0].equals(board1[1][1]) && board1[1][1].equals(board1[2][2]))
	{
		if (board1[0][0].equals(player))
			return +1;
		else if (board1[0][0].equals(player2))
			return -1;
	}

	if (board1[0][2].equals(board1[1][1]) && board1[1][1].equals(board1[2][0]))
	{
		if (board1[0][2].equals(player))
			return +1;
		else if (board1[0][2].equals(player2))
			return -1;
	}
	return 0;
}
public int minimax(String board[][], int depth, boolean isMax)
{
	int score = GivingPoints(board);
	if (score == 1)
		return score;
	if (score == -1)
		return score;
	if (checkingmovesleft(board)==false)
		return 0;
	if (isMax)
	{
		int best = -10;
		for (int i = 0; i<3; i++)
		{
			for (int j = 0; j<3; j++)
			{
				if (board[i][j].equals("-"))
				{
					board[i][j] = player;
					best = Math.max( best,minimax(board, depth+1, !isMax) );
					board[i][j] = "-";}}}
		return best;
	}
	else
	{
		int best = 10;
		for (int i = 0; i<3; i++)
		{
			for (int j = 0; j<3; j++)
			{
				if (board[i][j].equals("-"))
				{
					board[i][j] = player2;
					best = Math.min(best,minimax(board, depth+1, !isMax));
					board[i][j] = "-";	}	}	}
		return best;
	}
}
public operation findBestMove(String board[][])
{
	int bestVal = -10;
	operation bestMove= new operation();
	bestMove.row = -1;
	bestMove.column = -1;
	for (int i = 0; i<3; i++)
	{
		for (int j = 0; j<3; j++)
		{
			if (board[i][j].equals("-"))
			{
				board[i][j] = player;
				int moveVal = minimax(board, 0, false);
				board[i][j] = "-";
				if (moveVal > bestVal)
				{
					bestMove.row = i;
					bestMove.column = j;
					bestVal = moveVal;}}}}


	return bestMove;
}
}
//created by Vishal Kasa
public class tic
{
  public static void main(String[] args)
  {
      Scanner s1 = new Scanner(System.in);
      TicGame obj= new TicGame();
      new1 obj5=new new1();
      operation obj1=new operation();
      obj.initializeBoard();
      System.out.println("Welcome to tic-toe game");
      System.out.println("1.Two player Game\n2.Play with Computer");
      System.out.println("Enter Your Choice");
      int choice=s1.nextInt();
      if(choice==2) {
      do {
        System.out.println("CurrentBoard");
        obj.printBoard();
        int row;
        int column;
        do
         {
          if(obj.getCurrentPlayerMark().equals("o"))System.out.println("Player " + obj.getCurrentPlayerMark() + ", Place your mark and enter row and column");
          if(obj.getCurrentPlayerMark().equals("x"))
          {
        	operation bestMove = obj5.findBestMove(obj.board);
      		row=bestMove.row;
      		column=bestMove.column;
      		
          }
          else {
          row = s1.nextInt();
          column = s1.nextInt();
          }
         }
        while (!obj.MarkThePlace(row, column));
        obj.changePlayer();
      } while(!obj.checkWin() && !obj.isBoardFull());

      if (obj.isBoardFull() && !obj.checkWin())
      {
          System.out.println("Nice Attempt but game is tie");
      }
      else
      {
        System.out.println("Current board layout:");
        obj.printBoard();
        obj.changePlayer();
        System.out.println("Congratulation");
        System.out.println(obj.getCurrentPlayerMark() +" wins the game");
      }
}
      if(choice==1) {
    	  
    	  do {
    	        System.out.println("CurrentBoard");
    	        obj.printBoard();
    	        int row;
    	        int column;
    	        do
    	         {
    	          System.out.println("Player " + obj.getCurrentPlayerMark() + ", Place your mark and enter row and column");
    	          if(obj.getCurrentPlayerMark().equals("x"))
    	          {
    	        	operation bestMove = obj5.findBestMove(obj.board);
    	        	System.out.println("Best Move for X");
    	      		System.out.println("Put X at Row"+" "+bestMove.row+ " and column at "+bestMove.column);
    	      		row=s1.nextInt();
    	      		column=s1.nextInt();
    	      		
    	          }
    	          else {
    	          row = s1.nextInt();
    	          column = s1.nextInt();
    	          }
    	         }
    	        while (!obj.MarkThePlace(row, column));
    	        obj.changePlayer();
    	      } while(!obj.checkWin() && !obj.isBoardFull());

    	      if (obj.isBoardFull() && !obj.checkWin())
    	      {
    	          System.out.println("Nice Attempt but game is tie");
    	      }
    	      else
    	      {
    	        System.out.println("Current board layout:");
    	        obj.printBoard();
    	        obj.changePlayer();
    	        System.out.println("Congratulation");
    	        System.out.println(obj.getCurrentPlayerMark() +" wins the game");
    	      }
      }
  }
}
