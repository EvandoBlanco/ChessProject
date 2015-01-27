import javax.swing.ImageIcon;

public class Rook extends Piece{
	
	//Chooses piece color
	public Rook(boolean isblack){
		  
		 if(isblack){
			 piece=new ImageIcon("blackRook.gif");
		 }
		 if(isblack==false){
			 piece=new ImageIcon("whiteRook.gif");
		 }
		 yesblack = isblack;
	}
	
	//Checks movement

	@Override
	public boolean canMove(int startX, int startY, int endX, int endY) {
		
		boolean okMovement=false;
		int moveLocationX=startX-endX;
		moveLocationX=Math.abs(moveLocationX);
		
		int moveLocationY=startY-endY;
		moveLocationY=Math.abs(moveLocationY);
		
		if(moveLocationX==0 && moveLocationY!=0){
			//Y-direction movement
			okMovement=true;
			if(startY-endY<0){
				for(int i=startY+1; i<endY; i++){
					if(Chess.boardPosition[startX][i]!=null){
						okMovement=false;
					}
				}
			}
			
			if(startY-endY>0){
				for(int i=endY+1; i<startY; i++){
					if(Chess.boardPosition[startX][i]!=null){
						okMovement=false;
					}
				}
			}
		}
		
		
		if(moveLocationX!=0 && moveLocationY==0){
			//X-movement
			okMovement=true;
			if(startX-endX<0){
				for(int i=startX+1; i<endX; i++){
					if(Chess.boardPosition[i][startY]!=null){
						okMovement=false;
					}
				}
			}
			
			if(startX-endX>0){
				for(int i=endX+1; i<startX; i++){
					if(Chess.boardPosition[i][startY]!=null){
						okMovement=false;
					}
				}
			}
		}
		//Limits black movement to white pieces
		if(Chess.boardPosition[startX][startY].yesblack==true){
			
			if(Chess.boardPosition[endX][endY]!=null && Chess.boardPosition[endX][endY].yesblack==true){
				okMovement=false;
			}
		}
		//Limits white movement to black pieces 
		if(Chess.boardPosition[startX][startY].yesblack==false){
	
			if(Chess.boardPosition[endX][endY]!=null && Chess.boardPosition[endX][endY].yesblack==false){
				okMovement=false;
			}
		}
		
		return okMovement;
	}

}
