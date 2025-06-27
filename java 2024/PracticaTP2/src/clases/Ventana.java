package clases;

import javax.swing.JFrame;

public class Ventana extends JFrame
{
	public Ventana()
	{
		setTitle("Pelotitas");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Lienzo tablero = new Lienzo();
		add (tablero);
	}
}
