package classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	private String paint ="";

	public PaintPanel(String paint) {
		 super();
		 this.paint=paint;
		 setOpaque(true);
	}

	@Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       if (paint=="water") {
        	water(g);
       }

       if (paint=="ground") {
			ground(g);
       }
    }

	public void water(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

	    // Aquarium zeichnen
	    GradientPaint gp = new GradientPaint(this.getWidth()/2, 0, new Color(0,200,200),
	    	           		this.getWidth()/2, this.getHeight(), new Color(0,150,250));
	    g2d.setPaint(gp);
	    g2d.fillRect(0, 70, getWidth(), getHeight());
	}

	public void ground(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		//Boden zeichnen
		g2d.setPaint(new Color(180,150,120));
        g2d.setStroke(new BasicStroke(150));
        g2d.drawLine(getWidth(), getHeight(), 0, getHeight());
	}
}
