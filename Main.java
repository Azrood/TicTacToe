import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Board tableau = new Board();
        Player player = new Player();

		tableau.display();
		Scanner read=new Scanner(System.in);
		while (tableau.winOrDraw(player)==false)
		{
			System.out.println("Tour du joueur " + player.getPlayer());
			tableau.display();
			if (player.play(read.nextLine(),tableau)) player.changePlayer();
			
        }

        read.close();
    }
}