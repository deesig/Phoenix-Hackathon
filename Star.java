import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;

public class Star {
	//fields
private int x;
private int y;
private ImageIcon image;
private ImageIcon image2;

	//class
	public Star(int x, int y) {
		this.x = x;
		this.y = y;
		image = new ImageIcon("Star.gif");
		image2 = new ImageIcon("Star2.gif");

	}
	
	public void drawStar(Graphics g) {
		g.drawImage(image.getImage(),x, y, 100, 100, null);					
	}

}


	
