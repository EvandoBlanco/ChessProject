import javax.swing.ImageIcon;


public class Bishop extends Piece{
	
	//Chooses Color
	public Bishop(boolean isblack){
		  
		 if(isblack){
			 piece=new ImageIcon("blackBishop.gif");
		 }
		 if(isblack==false){
			 piece=new ImageIcon("whiteBishop.gif");
		 }
		 yesblack = isblack;
	}
	
	//Limits bishop movement
	@Override
	public boolean canMove(int startX, int startY, int endX, int endY) {
		
		boolean okMovement;
		int moveLocationX=startX-endX;
		moveLocationX=Math.abs(moveLocationX);
		
		int moveLocationY=startY-endY;
		moveLocationY=Math.abs(moveLocationY);
		
		//All diagonal movement has equal x and y change
		if(moveLocationX==moveLocationY){
			okMovement=true;
			//Each checks for pieces in a given direction
			if(startX-endX>0 && startY-endY<0){
				for(int i=endX+1;i<startX;i++){
					int j=endY-1;
					if(Chess.boardPosition[i][j]!=null){
						okMovement=false;
					}
				}
			}
			
			if(startX-endX<0 && startY-endY>0){
				for(int i=endX-1;i>startX;i--){
					int j=endY+1;
					if(Chess.boardPosition[i][j]!=null){
						okMovement=false;
					}
				}
			}
			
			if(startX-endX<0 && startY-endY<0){
				for(int i=endX-1;i>startX;i--){
					int j=endY-1;
					if(Chess.boardPosition[i][j]!=null){
						okMovement=false;
					}
				}
			}
			
			if(startX-endX>0 && startY-endY>0){
				for(int i=endX+1;i<startX;i++){
					int j=endY+1;
					if(Chess.boardPosition[i][j]!=null){
						okMovement=false;
					}
				}
			}
		}
		
		else{
			okMovement=false;
		}

		return okMovement;
	}
}
