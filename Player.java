public class Player 
{
    private char player;

    protected char getPlayer()
	{
		return player;
    }
    
    protected void changePlayer()
	{	
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
		if (plat.getContent(x,y)==' ')
		{
			if (this.getPlayer()=='x') plat.setContent(x,y,'x');
			else plat.setContent(x,y,'o');
			return true;
		}
		else return false;
	}
}