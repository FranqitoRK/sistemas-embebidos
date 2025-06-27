package clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lienzo extends JPanel
{
	JLabel label1;
	Fotopata objeto1;
	
	public Lienzo()
	{
		setLayout(null);
		label1=new JLabel("una boludez");
		label1.setBounds(185,50,150,40);
		label1.setFont(new Font("arial",Font.BOLD,20));
		add(label1);
		
		objeto1=new Fotopata(140,100);
		repaint();
	}
	public void establecerColorTexto(int a) 
	{
		if(a==1) 
		{
			label1.setForeground(new Color(255,0,255));
		}
		if(a==2) 
		{
			label1.setForeground(new Color(255,180,0));
		}
	}
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(objeto1.devolverImagen(),objeto1.devolverX(),objeto1.devolverY(),null);
	}
	
}