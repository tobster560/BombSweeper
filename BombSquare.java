import java.util.*;

public class BombSquare extends GameSquare
{
	public int t;
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private GameSquare[] beenClicked = new GameSquare[0];
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
		System.out.println(t);
		t++;
		if (t >1){
			return;
		} 
		System.out.println("clicked");
		beenClicked = beenClicked(xLocation,yLocation, beenClicked);
			
			if (thisSquareHasBomb == true){
				setImage("images/bomb.png");
				System.out.println("bomba");
			}
			
			else if(bombCheck(xLocation, yLocation) == 0){
				setImage("images/0.png");
				sweep(xLocation,yLocation);
			}
			else if(bombCheck(xLocation, yLocation) == 1){
				setImage("images/1.png");
			}
			else if(bombCheck(xLocation, yLocation) == 2){
				setImage("images/2.png");
			}
			else if(bombCheck(xLocation, yLocation) == 3){
				setImage("images/3.png");
			}
			else if(bombCheck(xLocation, yLocation) == 4){
				setImage("images/4.png");
			}
			else if(bombCheck(xLocation, yLocation) == 5){
				setImage("images/5.png");
			}
			else if(bombCheck(xLocation, yLocation) == 6){
				setImage("images/6.png");
			}
			else if(bombCheck(xLocation, yLocation) == 7){
				setImage("images/7.png");
			}
			else if(bombCheck(xLocation, yLocation) == 8){
				setImage("images/8.png");
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

	public GameSquare[] beenClicked(int x, int y, GameSquare beenClicked[]){
		
		GameSquare[] newbeenClicked = new GameSquare[beenClicked.length + 1];
		for(int i =0; i<beenClicked.length; i++){
			newbeenClicked[i] = beenClicked[i];
			
		}
		newbeenClicked[beenClicked.length] = board.getSquareAt(x, y);
		return newbeenClicked;
		
	}
	public boolean hasBeenClicked(GameSquare [] beenClicked, int x, int y){
		
		for(int i=0; i< beenClicked.length; i++){
			/*if (beenClicked[i].xLocation == x && beenClicked[i].yLocation == y){
				return true;
			} */
			if(beenClicked[i] == board.getSquareAt(x, y)){
				return true;
			}
		}
		
		return false;
	}

	public void sweep(int x , int y){
		GameSquare right = board.getSquareAt(x+1, y);
		GameSquare left = board.getSquareAt(x -1 , y);
		GameSquare down = board.getSquareAt(x, y + 1);
		GameSquare up = board.getSquareAt(x, y - 1);
		GameSquare downright = board.getSquareAt(x + 1, y + 1);
		GameSquare downleft = board.getSquareAt(x -1 , y + 1);
		GameSquare upright = board.getSquareAt(x + 1, y -1);
		GameSquare upleft = board.getSquareAt(x - 1, y - 1);
		if (up != null && !hasBeenClicked(beenClicked, x, y - 1)) {
			up.clicked();
		}
		if (down != null && !hasBeenClicked(beenClicked, x, y + 1)) {
			down.clicked();
		}
		if (right != null && !hasBeenClicked(beenClicked, x, y + 1)) {
			right.clicked();
		}
		if (left != null && !hasBeenClicked(beenClicked, x-1, y )) {
			left.clicked();
		}
		if (downright != null && !hasBeenClicked(beenClicked, x + 1, y + 1)) {
			downright.clicked();
		}
		if (downleft != null && !hasBeenClicked(beenClicked, x - 1, y + 1)) {
			downleft.clicked();
		}
		if (upright != null && !hasBeenClicked(beenClicked, x + 1, y - 1)) {
			upright.clicked();
		}
		if (upleft != null && !hasBeenClicked(beenClicked, x - 1, y - 1)) {
			upleft.clicked();
		} 
		 

		return;
	}
}
