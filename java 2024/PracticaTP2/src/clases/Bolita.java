package clases;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bolita 
{
	Image imagen;
	int x, y;
	
	public Bolita(int xe, int ye, int im)
	{
		imagen = new ImageIcon(getClass().getResource("Img/"+im+".png")).getImage();
		x = xe;
		y = ye;
	}
	
	public void setImg(int numI) 
	{
		imagen = new ImageIcon(getClass().getResource("Img/"+numI+".png")).getImage();
	}
	
	public void setX(int xe)
	{
		x=xe;
	}
	
	public void setY(int ye)
	{
		y=ye;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImg()
	{
		return imagen;
	}
}