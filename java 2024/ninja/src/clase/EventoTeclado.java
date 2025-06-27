package clase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventoTeclado extends KeyAdapter
{
	static boolean up,down;
	
	@Override
	public void  keyPressed(KeyEvent e)
	{
		int id=e.getKeyCode();

		if(id==KeyEvent.VK_UP || id==KeyEvent.VK_SPACE)
		{
			up=true;
		}
		if(id==KeyEvent.VK_DOWN || id==KeyEvent.VK_ENTER)
		{
			down=true;
		}
	}
	public void  keyReleased(KeyEvent e)
	{
		int id=e.getKeyCode();

		if(id==KeyEvent.VK_UP || id==KeyEvent.VK_SPACE)
		{
			up=false;
		}
		if(id==KeyEvent.VK_DOWN || id==KeyEvent.VK_ENTER)
		{
			down=false;
		}
	}

}
