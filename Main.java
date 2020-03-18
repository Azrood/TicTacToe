import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Board tableau = new Board();
        Player player = new Player();

		tableau.display();
		Scanner read=new Scanner(System.in);
		while (true)
		{
			System.out.println("Tour du joueur " + player.getPlayer());
            if (player.play(read.nextLine(),tableau))
                {
                    if(!tableau.winOrDraw(player)) player.changePlayer();
                    else
                    {
                        tableau.display();
                        break;
                    }
                }
            tableau.display();
        }
        read.close();
    }
}