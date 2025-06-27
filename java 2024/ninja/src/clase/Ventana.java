package clase;

import javax.swing.JFrame;

public class Ventana extends JFrame
{
	public Ventana()
	{
		setTitle("no se");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setFocusable(true);
		Lienzo tablero=new Lienzo();
		add(tablero);
		addKeyListener(new EventoTeclado());
	}
}