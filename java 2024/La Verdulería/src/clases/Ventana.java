package clases;

import javax.swing.JFrame;

public class Ventana extends JFrame
{
	public Ventana()
	{
		setTitle("Rufus Gameplay");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		
		Lienzo tablero = new Lienzo();
		add (tablero);
		
		addKeyListener(new Teclado());
	}
}
