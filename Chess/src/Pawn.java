import javax.swing.ImageIcon;

public class Pawn extends Piece{
	
	//Sets black or white image
	public Pawn(boolean isblack){
		  
		 if(isblack){
			 piece=new ImageIcon("blackPawn.gif");
		 }
		 else{
			 piece=new ImageIcon("whitePawn.gif");
		 }
		 yesblack = isblack;
	}

	//Checks to see if piece can move legally
	@Override
	public boolean canMove(int startX, int startY, int endX, int endY) {
		
		boolean okMovement=false;
		int moveLocationX=startX-endX;
		moveLocationX=Math.abs(moveLocationX);
		
		int moveLocationY=startY-endY;
		
		//White pawn movement
		if(Chess.boardPosition[startX][startY].yesblack==false){
			
		//Various pawn movement rules
			if(moveLocationY==1 && moveLocationX==0){

					if(Chess.boardPosition[endX][endY]!=null){
					
						okMovement=false;
					}
					
					else{
						okMovement=true;
					}
			}
	
			//Allows for two space movement on first turn
			if(startY==6 && moveLocationY==2 && Chess.boardPosition[endX][endY]==null && moveLocationX==0){
				okMovement=true;
				//Stops it from jumping over a piece
				for(int i=endY+1; i<startY; i++){
					if(Chess.boardPosition[startX][i]!=null){
						okMovement=false;
					}
				}
			}
			//Attacking rules
			if(moveLocationY==1 && moveLocationX==1){
				
				if(Chess.boardPosition[endX][endY].yesblack==true){
					
					okMovement=true;
				}
			
				else{
					okMovement=false;
				}
			
			}
			//Stops it from moving in a white piece
			if(Chess.boardPosition[endX][endY]!=null){
				
				if(Chess.boardPosition[endX][endY].yesblack==false){
					
					okMovement=false;
				}
			}
		
		}
		
		//Black pawn movement
		if(Chess.boardPosition[startX][startY].yesblack==true){
			//Various pawn movement rules
			if(moveLocationY==-1 && moveLocationX==0){
	
					if(Chess.boardPosition[endX][endY]!=null){
					
						okMovement=false;
					}
					
					else{
						okMovement=true;
					}
			}
			//Allows for two space movement on first turn
			if(startY==1 && moveLocationY==-2 && Chess.boardPosition[endX][endY]==null && moveLocationX==0){
				okMovement=true;
				//Stops it from jumping over a piece
				for(int i=endY-1; i>startY; i--){
					if(Chess.boardPosition[startX][i]!=null){
						okMovement=false;
					}
				}
			}
			//Attacking rules
			if((moveLocationY==-1 && moveLocationX==1) && Chess.boardPosition[endX][endY]!=null){
				
				if(Chess.boardPosition[endX][endY].yesblack==false){
					
					okMovement=true;
				}
			
				else{
					okMovement=false;
				}
			
			}
			//Stops it from moving in a white piece
			if(Chess.boardPosition[endX][endY]!=null){
				
				if(Chess.boardPosition[endX][endY].yesblack==true){
					
					okMovement=false;
				}
			}
		}
		return okMovement;
	}
		
}
