
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class Piece extends JComponent {
	ImageIcon piece;
	public boolean yesblack;
	//Initializes move function
	public abstract boolean canMove(int startX,  int startY, int endX, int endY);
	
	//Draws piece
	public void drawPiece(Graphics g,int x,int y){
		if(piece==null){
		
		}
		else{
			g.drawImage(piece.getImage(), x, y, null);
		}
	}
	
	
	
}
