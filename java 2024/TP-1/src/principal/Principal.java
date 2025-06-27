package principal;

import clase.Ventana;

public class Principal 
{
	public static void main(String[]args)
	{
		Ventana interfaz = new Ventana();
		interfaz.setBounds(0,0,600,500);
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);
		interfaz.setAlwaysOnTop(false);
	}
}