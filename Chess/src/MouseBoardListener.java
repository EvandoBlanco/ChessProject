import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseBoardListener implements MouseListener, MouseMotionListener {
	public int xClick;
	public int yClick;
	
	public int xRelease;
	public int yRelease;
	
	public Piece currentPiece;
	public Piece compPiece;
	
	public boolean turn;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//Gets position of mouse click
		xClick=(arg0.getX())/47;
		yClick=(arg0.getY()-32)/44;
		currentPiece=Chess.boardPosition[xClick][yClick];
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//Gets position of mouse release
		turn=true;
		xRelease=(arg0.getX())/46;
		yRelease=(arg0.getY()-32)/44;
		
		boolean moveCheck=Chess.boardPosition[xClick][yClick].canMove(xClick, yClick, xRelease, yRelease);
		boolean compCheck;
		boolean compMoveFinish=false;
		//Checks if white (i.e. user's pieces)
		if(Chess.boardPosition[xClick][yClick].yesblack==false){
			if(moveCheck==true){ 
				Chess.boardPosition[xRelease][yRelease]=currentPiece;
			}
			else{
				Chess.boardPosition[xClick][yClick]=currentPiece;	
			}
		
			if((xClick != xRelease || yClick != yRelease)&& moveCheck==true){
			
				Chess.boardPosition[xClick][yClick]=null;
				turn=false;
			}
			
		}
		//Handles opponet's moves
		if(turn==false){
			//Ensures user is finished move
			while(compMoveFinish!=true){
				//Chooses random starting position
				double randY=Math.random();
				double randX=Math.random();
			
				randY=randY*8;
				int randomY=(int)randY;
			
				randX=randX*8;
				int randomX=(int)randX;
				//If it chooses a black piece
				if(Chess.boardPosition[randomX][randomY]!=null && Chess.boardPosition[randomX][randomY].yesblack==true){
					compPiece=Chess.boardPosition[randomX][randomY];
					//chooses random end position
					for(int i=0;i<10000;i++){
						double compRandX=Math.random();
						double compRandY=Math.random();
					
						compRandX=compRandX*8;
						int compRandomX=(int)compRandX;
					
						compRandY=compRandY*8;
						int compRandomY=(int)compRandY;
						//Checks if end move position is valid
						compCheck=Chess.boardPosition[randomX][randomY].canMove(randomX, randomY, compRandomX, compRandomY);
						if(compCheck==true && (randomX!=compRandomX || randomY!=compRandomY)){
							// Moves piece and breaks loops
							Chess.boardPosition[compRandomX][compRandomY]=compPiece;
							Chess.boardPosition[randomX][randomY]=null;
							compMoveFinish=true;
							System.out.println("broken");
							break;
						}
						
					}
				}
			}
		}
				
	}
}
