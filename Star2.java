import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;

public class Star2 {
	//fields
private int x;
private int y;
private ImageIcon image;

	//class
	public Star2(int x, int y) {
		this.x = x;
		this.y = y;
		image = new ImageIcon("Star2.gif");
	}
	

	public void drawStar2(Graphics g) {
		g.drawImage(image.getImage(),x, y, 100, 100, null);					
		
	}
}


	
