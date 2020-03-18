public class Player 
{
    private char player;

    protected char getPlayer()
	{
		return player;
    }
    
    protected void changePlayer()
	{ 
        // TODO : check if round is played correctly before changing
		if (this.getPlayer() == 'x') this.player = 'o';
		else this.player = 'x';
    }
    
    public Player()
    {
        this.player = 'x';
    }

    protected Boolean play(String position, Board plat)
	{
		int x = plat.getPosition(position)[0];
		int y = plat.getPosition(position)[1];
		if (plat.Board[x][y]==' ')
		{
            // TODO : to be properly implemented
			if (this.getPlayer()=='x') plat.Board[x][y] = 'x';	
			else plat.Board[x][y] = 'o';
			return true;
		}
		else return false;
	}
}