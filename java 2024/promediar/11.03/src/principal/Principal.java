package principal;

import clase.Ventana;

public class Principal 
{
	public static void main(String[]args)
	{
		Ventana interfaz = new Ventana();
		interfaz.setBounds(0,0,350,300);
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);
	}
}
