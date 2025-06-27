package clases;

import javax.swing.JFrame;

public class Ventana extends JFrame
{
	public Ventana()
	{
		setTitle("cat sprinting");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Lienzo tablero = new Lienzo();
		add (tablero);
	}
}
