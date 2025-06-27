package clase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Ventana extends JFrame implements ActionListener
{
	public Ventana()
	{
		setTitle("IMC CALCULATOR");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Lienzo tablero = new Lienzo();
		add(tablero);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}