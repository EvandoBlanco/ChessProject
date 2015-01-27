import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class ChessComponent extends JComponent {

	//Paints board pattern
	public void paintComponent(Graphics g){
		Color tan=new Color(233,174,95);
		Color brown=new Color(177,113,24);
		
		int tanX=0;
		int tanY=0;
		int brownY=0;
		int brownX=0;
		int row=1;
		int i;
		
		for(i=0; i<8; i++){
			
			//Paints row of alternating colors with tan square first
			if(row%2!=0){
				//Paints the tan squares
				for(i=0; i<4;i++){
					g.setColor(tan);
					g.drawRect(tanX, tanY, 44, 44);
					g.fillRect(tanX, tanY, 44, 44);
			
					tanX=tanX+88;
				}
				//Paints the brown squares
				for(i=0; i<4;i++){
					g.setColor(brown);
					g.drawRect(brownX+44, brownY, 44, 44);
					g.fillRect(brownX+44, brownY, 44, 44);
			
					brownX=brownX+88;
				}
				tanY=tanY+44;
				brownY=brownY+44;
			}

			//Paints row of alternating colors with brown square first
			else{
				//Paints brown squares
				for(i=0; i<4;i++){
					g.setColor(brown);
					g.drawRect(brownX, brownY, 44, 44);
					g.fillRect(brownX, brownY, 44, 44);
			
					brownX=brownX+88;
				}
				//paints tan squares
				for(i=0; i<4;i++){
					g.setColor(tan);
					g.drawRect(tanX+44, tanY, 44, 44);
					g.fillRect(tanX+44, tanY, 44, 44);
			
					tanX=tanX+88;
				}
				tanY=tanY+44;
				brownY=brownY+44;
			}
			//row is incrimented and the starting square's positon is returned to 0
			row++;
			tanX=0;
			brownX=0;

			//break if all rows are painted
			if(row>8){
				break;
			}
		}
		
		//Draws pieces to board
		for(i=0;i<8;i++){
			for(int j=0;j<8;j++){
				//Pieces are represented by !null elements of the board array
				if(Chess.boardPosition[i][j]!=null){
					Chess.boardPosition[i][j].drawPiece(g, i*44, j*44);
				}
			}
		}
	}
}
