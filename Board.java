public class Board {
	private char[][] Board = new char[3][3];

	public Board()
	{
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				this.Board[i][j]=' ';
			}
		}
	}

	protected char getContent(int x, int y)
	{
		return this.Board[x][y];
	}

	protected void setContent(int x, int y, char content)
	{
		this.Board[x][y] = content;
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

	private Boolean checkColonne(Player joueur)
	{
		char player = joueur.getPlayer();
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

	private Boolean checkLigne(Player joueur)
	{
		char player = joueur.getPlayer();
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

	private Boolean checkDiagonale(Player joueur)
	{
		char player = joueur.getPlayer();
		Boolean flag = true;

		for (int i=0;i<this.Board.length;i++)
		{
			if (this.Board[i][i] != player) flag=false;
		}
		if (flag) return flag;
		for(int i=0;i<this.Board.length;i++)
		{
			if (this.Board[2-i][i]!=player) flag=false;
		}
		return flag;
	}

	private Boolean joueurGagne(Player joueur)
	{
		return this.checkDiagonale(joueur) || this.checkLigne(joueur) || this.checkColonne(joueur);
	}

	private Boolean boardRempli()
	{
		for (int i=0;i<this.Board.length;i++)
		{
			for (int j=0;j<this.Board.length;j++)
			{
				if (this.Board[i][j]==' ') return false;
			}
		}
		return true;
	}

	protected Boolean winOrDraw(Player joueur)
	{
		if (this.joueurGagne(joueur)) 
		{
			System.out.println("le joueur "+joueur.getPlayer()+" a gagne");
			return true;
		}
		else if(this.boardRempli() && !this.joueurGagne(joueur)) 
			{
				System.out.println("Match nul !");
				return true;
			}
		else return false;
	}
	
}