import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;

public class XmasTree {
	//fields
private int x;
private int y;
private ImageIcon image;
private ImageIcon image2;

	//class
	public XmasTree(int x, int y) {
		this.x = x;
		this.y = y;
		image = new ImageIcon("Xmas Tree.gif");

	}
	
	public void drawTree(Graphics g) {
		g.drawImage(image.getImage(),x, y, 292, 450, null);					
	}

}


	
