package clases;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Objeto 
{
	int x,y,objeto1;
	Image imagen;
	
	public Objeto(int xe,int ye)
	{
		x=xe;
		y=ye;
	}
	
	public void setImg(int img)
	{
		imagen = new ImageIcon(getClass().getResource(("imgs/"+img+".png"))).getImage();
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