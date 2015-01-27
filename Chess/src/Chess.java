/* Written by Evan White for CSC281: Intro to Computer Science II

   Chess game for one player vs comp
   Note: comp player does not make tactical moves, only random legal ones
   		 Castling is not implimented for rooks, only the basic horizontal and vertical movment
*/
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Chess {
	
	/*Array of pieces on the chessboard
	  Empty spaces are null
	*/
	public static Piece boardPosition[][]=new Piece[8][8];

	//Intilialize board component (checkerboard pattern)
	public static ChessComponent boardPattern=new ChessComponent();

	public static void main(String[] args){
	// Initialize window
		
		JFrame gameWindow=new JFrame("Evan's Chess Game");
		gameWindow.setSize(369, 390);

	//Initialize mouse listener and add it to window
		MouseBoardListener mouse=new MouseBoardListener();
		gameWindow.addMouseMotionListener(mouse);
		gameWindow.addMouseListener(mouse);

		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	/*Initialized pieces on board
	  Pieces are hardcoded to starting positions
	*/
		for(int i=0;i<8;i++){
			boardPosition[i][1]=new Pawn(true);
			boardPosition[i][6]=new Pawn(false);
		}
		
		boardPosition[0][0]=new Rook(true);
		boardPosition[7][0]=new Rook(true);
		boardPosition[0][7]=new Rook(false);
		boardPosition[7][7]=new Rook(false);
		
		boardPosition[1][0]=new Knight(true);
		boardPosition[6][0]=new Knight(true);
		boardPosition[1][7]=new Knight(false);
		boardPosition[6][7]=new Knight(false);
		
		boardPosition[2][0]=new Bishop(true);
		boardPosition[5][0]=new Bishop(true);
		boardPosition[2][7]=new Bishop(false);
		boardPosition[5][7]=new Bishop(false);
		
		boardPosition[4][0]=new King(true);
		boardPosition[4][7]=new King(false);
		
		boardPosition[3][0]=new Queen(true);
		boardPosition[3][7]=new Queen(false);
		
		//Draws chessboard and pieces on windown
		gameWindow.add(boardPattern);
		
		
		
		gameWindow.setVisible(true);
	
	//Window repaints every 10 nanoseconds
		while(true){
			
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException e)
			{
				
			}
			
			gameWindow.repaint();
		}
		
	}
}

