package clases;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Objeto 
{
	int x, y;
	Image gatito;
	
	public Objeto(int xe,int ye)
	{
		gatito = new ImageIcon(getClass().getResource("Media/1.png")).getImage();
		x = xe;
		y = ye;
	}
	
	public void EstablecerImagen(int numI) 
	{
		gatito = new ImageIcon(getClass().getResource("Media/" + numI + ".png")).getImage();
	}
	
	public void establecerX(int xe)
	{
		x=xe;
	}
	
	public void establecerY(int ye)
	{
		y=ye;
	}
	
	public int devolverX()
	{
		return x;
	}
	
	public int devolverY()
	{
		return y;
	}
	
	public Image devolverImagen()
	{
		return gatito;
	}
}
