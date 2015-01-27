import javax.swing.ImageIcon;
public class Knight extends Piece{
	
	//Chooses color
	 public Knight(boolean isblack){
		  
		 if(isblack){
			 piece=new ImageIcon("blackKnight.gif");
		 }
		 if(isblack==false){
			 piece=new ImageIcon("whiteKnight.gif");
		 }
		 yesblack = isblack;
	}

	 //Checks movement
	@Override
	public boolean canMove(int startX, int startY, int endX, int endY) {
		boolean okMovement;
		int moveLocationX=startX-endX;
		moveLocationX=Math.abs(moveLocationX);
		
		int moveLocationY=startY-endY;
		moveLocationY=Math.abs(moveLocationY);
		
		//Knight movements specifics
		
		if((moveLocationX==2 && moveLocationY==1)||(moveLocationX==1 && moveLocationY==2)){
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
