package clase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame implements ActionListener
{
	JMenu menu1,sub1,sub2;
	JMenuItem item1,item2,item3,item4,item5;
	JMenuBar barra1;
	Lienzo tablero;
	public Ventana()
	{
		setTitle("Menu Test");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tablero = new Lienzo();
		add(tablero);
		
		barra1=new JMenuBar();
		setJMenuBar(barra1);
		menu1=new JMenu("Menu");
		barra1.add(menu1);
		barra1.setBackground(new Color(180,180,180));
		sub1=new JMenu("Fondo");
		menu1.add(sub1);
		item1=new JMenuItem("Rojo");
		item1.addActionListener(this);
		sub1.add(item1);
		item2=new JMenuItem("Verde");
		item2.addActionListener(this);
		sub1.add(item2);
		item3=new JMenuItem("Azul");
		item3.addActionListener(this);
		sub1.add(item3);
		sub2=new JMenu("Letra");
		menu1.add(sub2);
		item4=new JMenuItem("Violeta");
		item4.addActionListener(this);
		sub2.add(item4);
		item5=new JMenuItem("Naranja");
		item5.addActionListener(this);
		sub2.add(item5);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==item1) 
		{
			tablero.setBackground(new Color(255,0,0));
		}
		if(e.getSource()==item2) 
		{
			tablero.setBackground(new Color(0,255,0));
		}
		if(e.getSource()==item3) 
		{
			tablero.setBackground(new Color(0,0,255));
		}
		if(e.getSource()==item4) 
		{
			tablero.establecerColorTexto(1);
		}
		if(e.getSource()==item5) 
		{
			tablero.establecerColorTexto(2);
		}
		
	}
}