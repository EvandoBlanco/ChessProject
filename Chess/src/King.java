import javax.swing.ImageIcon;


public class King extends Piece{
	//Chooses color
	public King(boolean isblack){
		  
		 if(isblack){
			 piece=new ImageIcon("blackKing.gif");
		 }
		 if(isblack==false){
			 piece=new ImageIcon("whiteKing.gif");
		 }
		 yesblack = isblack;
	}

	@Override
	//Movement rules
	public boolean canMove(int startX, int startY, int endX, int endY) {
		
		boolean okMovement;
		int moveLocationX=startX-endX;
		moveLocationX=Math.abs(moveLocationX);
		
		int moveLocationY=startY-endY;
		moveLocationY=Math.abs(moveLocationY);
		//Moves one space in any direction
		if(moveLocationX<=1 && moveLocationY<=1){
			okMovement=true;
		}
		
		else{
			okMovement=false;
		}
		
		if(Chess.boardPosition[startX][startY].yesblack==true){
			
			if(Chess.boardPosition[endX][endY]!=null && Chess.boardPosition[endX][endY].yesblack==true){
				okMovement=false;
			}
		}
		
		if(Chess.boardPosition[startX][startY].yesblack==false){
	
			if(Chess.boardPosition[endX][endY]!=null && Chess.boardPosition[endX][endY].yesblack==false){
				okMovement=false;
			}
		}
		
		return okMovement;
	}

}
