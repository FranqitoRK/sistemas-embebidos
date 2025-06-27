package clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lienzo extends JPanel implements ActionListener
{

	JLabel etiqueta1,etiqueta2,etiqueta3, etiqueta4;
	JTextField campo1;
	JButton boton, boton1;
	Objeto gato;
	Timer gatitom;
	int numY=450, numX, numI;
	
	public Lienzo()
	{
		setLayout(null);	
		gato = new Objeto(0,0);
		gatitom = new Timer(45, this);
		gatitom.start();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(gato.devolverImagen(),gato.devolverX(),gato.devolverY(),null);
	}
	
	public void actionPerformed(ActionEvent eventito)
	{     
		
	    numI = numI + 1;
	    
	    if (numI == 7)
	    {
	        numI = 1;
	    }
	    
	    gato.EstablecerImagen(numI);
	    
	    numX = numX + 15;
	    
	    if (numX >= 790)
	    {
	        numX = -160;
	        numY = (int)(Math.random()*450);
	    }
	    
	    gato.establecerX(numX);
	    gato.establecerY(numY);

	    repaint();
	}
}