import java.util.Scanner;
public class Board {
	private char[][] Board = new char[3][3];
	char player;

	protected char getPlayer()
	{
		return player;
	}

	protected void changePlayer()
	{
		if (this.getPlayer() == 'x') this.player = 'o';
		else this.player = 'x';
	}

	public Board()
	{
		this.player = 'x';
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				this.Board[i][j]=' ';
			}
		}
	}
	
	public void display()
	{
		System.out.print(" \t 1   2   3\n");
		for (int i=0;i<3;i++)
		{
			switch(i)
			{
				case 0: System.out.print("A\t");
						break;
				case 1: System.out.print("B\t");
						break;
				case 2: System.out.print("C\t");
						break;
			}
			for (int j=0;j<3;j++)
			{	
				System.out.print(this.Board[i][j]);
				if (j!=2) System.out.print("  | ");
			}
			if (i!=2) System.out.print("\n\t---|----|---\n");
		}
		System.out.println("\n");
	}

	protected int[] getPosition(String position)
	{
		int[] coord = new int[2];
		switch(position.charAt(0))
		{
		case 'A': coord[0]=0;
				break;
		case 'B': coord[0]=1;
				break;
		case 'C': coord[0]=2;
		}
		switch(position.charAt(1))
		{
			case '1': coord[1]=0;
					break;
			case '2': coord[1]=1;
					break;
			case '3': coord[1]=2;
					break;
		}
		return coord;
	}

	protected Boolean play(String position)
	{
		int x=getPosition(position)[0];
		int y=getPosition(position)[1];
		if (this.Board[x][y]==' ')
		{
			if (this.getPlayer()=='x') this.Board[x][y] = 'x';	
			else this.Board[x][y] = 'o';
			return true;
		}
		else return false;
	}

	protected Boolean checkColonne()
	{
		char player = this.getPlayer();
		Boolean flag=true;
		for (int i=0;i<3;i++)
		{
			flag=true;
			for (int j=0;j<3;j++)
			{
				if (this.Board[j][i] != player) return false;
			}
			if (flag) return flag;
		}
		return flag;
	}

	protected Boolean checkLigne()
	{
		char player = this.getPlayer();
		Boolean flag=true;
		for (int i=0;i<3;i++)
		{
			flag=true;
			for (int j=0;j<3;j++)
			{
				if (this.Board[i][j] != player) flag = false;
			}
			if (flag) return flag;
		}
		return flag;
	}

	protected Boolean checkDiagonale()
	{
		char player = this.getPlayer();
		Boolean flag=true;

		for (int i=0;i<3;i++)
		{
			if (this.Board[i][i] != player) flag=false;
		}
		if (flag) return flag;
		for(int i=0;i<3;i++)
		{
			if (this.Board[2-i][i]!=player) flag=false;
		}
		return flag;
	}

	protected Boolean joueurGagne()
	{
		return this.checkDiagonale() || this.checkLigne() || this.checkColonne();
	}

	protected Boolean winOrDraw()
	{
		if (this.joueurGagne()) 
		{
			System.out.println("le joueur "+this.getPlayer()+" a gagne");
			return true;
		}
		else if(this.boardRempli() && !this.joueurGagne()) 
			{
				System.out.println("Match nul !");
				return true;
			}
		else return false;
	}

	protected Boolean boardRempli()
	{
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				if (this.Board[i][j]==' ') return false;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		Board tableau = new Board();
		tableau.display();
		Scanner read=new Scanner(System.in);
		while (tableau.winOrDraw()==false)
		{
			System.out.println("Tour du joueur "+tableau.getPlayer());
			tableau.display();
			tableau.play(read.nextLine());
			tableau.changePlayer();
		}
	}
}