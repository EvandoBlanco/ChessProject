import javax.swing.ImageIcon;

public class Queen extends Piece{
//Sets Queen color	
	public Queen(boolean isblack){
		  
		 if(isblack){
			 piece=new ImageIcon("blackQueen.gif");
		 }
		 if(isblack==false){
			 piece=new ImageIcon("whiteQueen.gif");
		 }
		 yesblack = isblack;
	}

	@Override
	public boolean canMove(int startX, int startY, int endX, int endY) {
		boolean okMovement=false;
		int moveLocationX=startX-endX;
		moveLocationX=Math.abs(moveLocationX);
		//Movement is combination of bishop and rook *see them if needed
		int moveLocationY=startY-endY;
		moveLocationY=Math.abs(moveLocationY);
		
		if(moveLocationX==moveLocationY){
			okMovement=true;
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
		
		if(moveLocationX==0 && moveLocationY!=0){
			
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
