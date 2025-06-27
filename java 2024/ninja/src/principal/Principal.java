package principal;

import clase.Ventana;

public class Principal 
{
	public static void main(String[]args)
	{
		Ventana interfaz = new Ventana();
		interfaz.setBounds(0,0,1000,800);
		interfaz.setResizable(false);
	}

}