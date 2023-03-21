package pruebas;

import java.awt.Color;

/**
 * @author FERNANDO ROMERO DE ÁVILA - 1º DAW 2022-23	
 */
public class Arrays {

    /**
     * @param args
     */
    public static void main(String[] args) {

	
	
	   for (int i=0; i<(COUNT_BLOCKS_X*COUNT_BLOCKS_Y); i++) {

			if (this.x == 1 ) {
			    g.setColor(Color.RED);
			    if (this.y == 2) {
				g.setColor(Color.YELLOW);
			    }else {		    
				 g.setColor(Color.BLUE);
				    if (this.y == 4) {
					g.setColor(Color.GREEN);
				    }
			    }
			    g.fillRect((int) left(), (int) top(), (int) sizeX, (int) sizeY)

			}




			/*
		    if (this.x % 2 == 0) {
			g.setColor(Color.RED);
			if (this.y % 2 == 0) {
			    g.setColor(Color.YELLOW);
			}
		    } else {
			g.setColor(Color.BLUE);
			if (this.y % 2 == 0) {
			    g.setColor(Color.GREEN);
			}
		    }

			 */

	
			
			

			
			
			

			if (mBrick.destroyed = true && mBrick.equals()) {
			    scoreboard.increaseScoreBlue();

			} else if (mBrick.destroyed == mBrick.equals(colors[1])) {
			    scoreboard.increaseScoreRed();

			} else if (mBrick.destroyed == mBrick.equals(colors[2])) {
			    scoreboard.increaseScoreGreen();

			} else {
			    scoreboard.increaseScoreYellow();
			}
