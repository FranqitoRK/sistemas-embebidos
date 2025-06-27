package clase;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horoscopo 
{
	int x,y,horo;
	Image imagen;
	boolean visible;
	public Horoscopo(int xe,int ye)
	{
		x=xe;
		y=ye;
	}
	
	public void setInvisible()
	{
		imagen = null;
		visible=false;
	}
	public void setAnimal(int h)
	{
		imagen = new ImageIcon(getClass().getResource(("Imags/h"+h+".png"))).getImage();
		visible = true;
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
