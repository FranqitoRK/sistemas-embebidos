package clase;

import javax.swing.JFrame;

public class Ventana extends JFrame
{
	public Ventana()
	{
		setTitle("Calculadora");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Lienzo tablero = new Lienzo();
		add(tablero);
	}
}
