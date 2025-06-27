package clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter
{
	static boolean izq,der;
	
	public Teclado() {}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int id=e.getKeyCode();
		if(id==KeyEvent.VK_LEFT) 
		{
			izq=true;
		}
		if(id==KeyEvent.VK_RIGHT) 
		{
			der=true;
		}
	}
	
	public void keyReleased(KeyEvent e) 
	{
		int id=e.getKeyCode();
		if(id==KeyEvent.VK_LEFT) 
		{
			izq=false;
		}
		if(id==KeyEvent.VK_RIGHT) 
		{
			der=false;
		}
	}
}
