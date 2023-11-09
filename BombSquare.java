import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private int Bombs =0;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}
	
	public boolean hasBomb(){
		return thisSquareHasBomb;
	}

	public void clicked()
	{		
		System.out.println("ADJ:"+ bombCheck(xLocation, yLocation));
			if (thisSquareHasBomb == true)
				setImage("Resources/images/bomb.png");
			
			else if(bombCheck(xLocation, yLocation) == 0){
				setImage("Resources/images/0.png");
			}
			else if(bombCheck(xLocation, yLocation) == 1){
				setImage("Resources/images/1.png");
			}
			else if(bombCheck(xLocation, yLocation) == 2){
				setImage("Resources/images/2.png");
			}
			else if(bombCheck(xLocation, yLocation) == 3){
				setImage("Resources/images/3.png");
			}
			else if(bombCheck(xLocation, yLocation) == 4){
				setImage("Resources/images/4.png");
			}
			else if(bombCheck(xLocation, yLocation) == 5){
				setImage("Resources/images/5.png");
			}
			
			
			
	
			

	}

	int bombCheck(int x, int y){
		int Bombs = 0;

		// Surrounding squares
		GameSquare[] adjSquares = {
			board.getSquareAt(x - 1, y - 1), // tlSquare
			board.getSquareAt(x, y - 1),     // tSquare
			board.getSquareAt(x + 1, y - 1), // trSquare
			board.getSquareAt(x + 1, y),     // rSquare
			board.getSquareAt(x + 1, y + 1), // brSquare
			board.getSquareAt(x, y + 1),     // bSquare
			board.getSquareAt(x - 1, y + 1), // blSquare
			board.getSquareAt(x - 1, y)      // lSquare
		};
	
		for (GameSquare square : adjSquares) {
			if (square instanceof BombSquare && ((BombSquare) square).hasBomb()) {
				Bombs++;
			}
		}
	
		return Bombs;
	}
}
