package clase;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Objeto 
{
	int x,y;
	Image imagen;
	public Objeto(int xe,int ye, int im)
	{
		imagen = new ImageIcon(getClass().getResource(("Imags/"+im+".png"))).getImage();
		x=xe;
		y=ye;
	}
	public void setX(int xe)
	{
		x=xe;
	}
	public void setY(int ye)
	{
		y=ye;
	}
	public void setImage(int im)
	{
		imagen = new ImageIcon(getClass().getResource(("Imags/"+im+".png"))).getImage();
	}
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return imagen;
	}
	

}