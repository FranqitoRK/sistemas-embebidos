package clase;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fotopata 
{
	Image imagen;
	int x,y;
	public Fotopata(int Xe,int Ye) 
	{
		imagen=new ImageIcon(getClass().getResource("imgs/1.png")).getImage();
		x=Xe;
		y=Ye;
	}
	public void establecerX(int Xe) 
	{
		x=Xe;
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
		return imagen;
	}
}